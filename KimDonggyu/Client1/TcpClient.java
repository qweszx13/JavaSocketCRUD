package KimDonggyu.Client1;

import java.io.IOException;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1";
        Socket socket = null;

        try {
            socket = new Socket(serverIP,7777);
            System.out.println("서버에 연결된듯요");

            TcpSender sender = new TcpSender(socket);
            TcpReceiver receiver = new TcpReceiver(socket);

            sender.start();
            receiver.start();

        }catch (Exception e){
            socket.close();
            e.printStackTrace();
        }
    }
}
