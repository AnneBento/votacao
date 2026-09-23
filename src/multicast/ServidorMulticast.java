package multicast;

import serializacao.Marshaller;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorMulticast {
    private static final String MULTICAST_ADDRESS = "230.0.0.1";
    private static final int PORT = 4446;

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress group = InetAddress.getByName(MULTICAST_ADDRESS);

        MensagemMulticast msg1 = new MensagemMulticast("NOTIFICACAO", "Novo candidato registrado");
        byte[] buffer1 = Marshaller.marshal(msg1);
        DatagramPacket packet1 = new DatagramPacket(buffer1, buffer1.length, group, PORT);
        socket.send(packet1);

        Thread.sleep(2000);

        MensagemMulticast msg2 = new MensagemMulticast("ALERTA", "Faltam 5 minutos para encerrar a votacao");
        byte[] buffer2 = Marshaller.marshal(msg2);
        DatagramPacket packet2 = new DatagramPacket(buffer2, buffer2.length, group, PORT);
        socket.send(packet2);

        socket.close();
    }
}
