package KimDonggyu;

import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) {
        String serverIP = "192.168.0.8";

        try {
            Socket socket = new Socket(serverIP,7777);
            System.out.println("서버에 연결된듯요");

            TcpSender sender = new TcpSender(socket);
            TcpReceiver receiver = new TcpReceiver(socket);

            sender.start();
            receiver.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
