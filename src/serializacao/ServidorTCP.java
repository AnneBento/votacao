package serializacao;

import servico.AutenticacaoService;
import servico.VotacaoService;
import modelo.Eleitor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    private static AutenticacaoService authService = new AutenticacaoService();
    private static VotacaoService votacaoService = new VotacaoService();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Servidor TCP rodando na porta 12345...");

        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(() -> tratarCliente(socket)).start();
        }
    }

    private static void tratarCliente(Socket socket) {
        try (DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

            int length = dis.readInt();
            byte[] bytesReq = new byte[length];
            dis.readFully(bytesReq);

            Request req = (Request) Marshaller.unmarshal(bytesReq);
            Reply reply = processarRequisicao(req);

            byte[] bytesRep = Marshaller.marshal(reply);
            dos.writeInt(bytesRep.length);
            dos.write(bytesRep);
            dos.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Reply processarRequisicao(Request req) {
        switch (req.getOperacao()) {
            case "LOGIN":
                Eleitor eleitor = authService.autenticar((String) req.getParametro());
                if (eleitor != null) {
                    return new Reply(true, eleitor, "Autenticado com sucesso");
                }
                return new Reply(false, null, "CPF invalido");
            case "LISTAR_CANDIDATOS":
                return new Reply(true, votacaoService.getListaCandidatos(), "Lista de candidatos");
            case "VOTAR":
                boolean votou = votacaoService.votar((Integer) req.getParametro());
                return new Reply(votou, null, votou ? "Voto computado" : "Falha ao votar");
            default:
                return new Reply(false, null, "Operacao desconhecida");
        }
    }
}
