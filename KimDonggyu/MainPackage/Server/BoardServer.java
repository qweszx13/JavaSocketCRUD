package KimDonggyu.MainPackage.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BoardServer {
    public static void run(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        System.out.println("Server Start");
        try {
            serverSocket = new ServerSocket(7777);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            try {
                socket = serverSocket.accept();
                BoardEachSocket board = new BoardEachSocket(socket);
                System.out.println(socket.getInetAddress()+"님 소켓 생성 접속");
                board.start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
