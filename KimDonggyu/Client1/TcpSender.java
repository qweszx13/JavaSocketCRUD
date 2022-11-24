package KimDonggyu.Client1;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TcpSender extends Thread{
    Socket socket;
    DataOutputStream out;
    String name;

    public TcpSender(Socket socket){
        try{
            out = new DataOutputStream(socket.getOutputStream());
            name = "["+socket.getInetAddress()+"|"+socket.getPort()+"]";
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        while(out != null){
            try{
                out.writeUTF(scan.nextLine());
            }catch (Exception e){
                try {
                    out.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }
}
