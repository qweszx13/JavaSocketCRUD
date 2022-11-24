package KimDonggyu.Client2;


import java.io.DataInputStream;
import java.net.Socket;

public class TcpReceiver extends Thread {
    Socket socket;
    DataInputStream in;
    String name;

    public TcpReceiver(Socket socket){
        try{
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while(!socket.isClosed()){
            try{
                System.out.println(in.readUTF());
            }catch (Exception e){
                if(socket.isClosed() == true)
                    System.exit(1);
            }
        }

    }
}
