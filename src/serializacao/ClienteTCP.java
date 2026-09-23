package serializacao;

import modelo.Eleitor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClienteTCP {
    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("localhost", 12345);
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

            Request req = new Request("LOGIN", "11111111111");
            byte[] reqBytes = Marshaller.marshal(req);

            dos.writeInt(reqBytes.length);
            dos.write(reqBytes);
            dos.flush();

            int length = dis.readInt();
            byte[] repBytes = new byte[length];
            dis.readFully(repBytes);

            Reply reply = (Reply) Marshaller.unmarshal(repBytes);
            if (reply.isSucesso()) {
                Eleitor e = (Eleitor) reply.getResultado();
                System.out.println("Login efetuado: " + e.getNome());
            } else {
                System.out.println("Erro: " + reply.getMensagem());
            }
        }
    }
}
