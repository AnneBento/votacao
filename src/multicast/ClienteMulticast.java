package multicast;

import serializacao.Marshaller;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ClienteMulticast {
    private static final String MULTICAST_ADDRESS = "230.0.0.1";
    private static final int PORT = 4446;

    public static void main(String[] args) throws Exception {
        MulticastSocket socket = new MulticastSocket(PORT);
        InetAddress group = InetAddress.getByName(MULTICAST_ADDRESS);
        socket.joinGroup(group);

        new Thread(() -> {
            try {
                byte[] buffer = new byte[1024];
                while (true) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);
                    byte[] data = new byte[packet.getLength()];
                    System.arraycopy(packet.getData(), 0, data, 0, packet.getLength());
                    
                    MensagemMulticast msg = (MensagemMulticast) Marshaller.unmarshal(data);
                    System.out.println("Multicast Recebido: " + msg);
                }
            } catch (Exception e) {
                System.out.println("Conexao encerrada.");
            }
        }).start();

        Thread.sleep(10000);
        socket.leaveGroup(group);
        socket.close();
    }
}
