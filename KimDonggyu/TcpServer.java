package KimDonggyu;

import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(7777);

            socket = serverSocket.accept();

            TcpSender sender = new TcpSender(socket);
            TcpReceiver receiver = new TcpReceiver(socket);

            sender.start();
            receiver.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
