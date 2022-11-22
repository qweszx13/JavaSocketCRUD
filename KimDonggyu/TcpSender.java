package KimDonggyu;


import org.json.simple.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class TcpSender extends Thread {
    Socket socket;
    DataOutputStream out;
    String name;
    Scanner scan = new Scanner(System.in);
    NoticeBoardShowContents show = new NoticeBoardShowContents();
    NoticeBoard func = new NoticeBoard();
    static private int num;// 리스트 넘버링
    static private LinkedList<JSONObject> myList = new LinkedList<>();

    public TcpSender(Socket socket){
        try{
            out = new DataOutputStream(socket.getOutputStream());
            name = "Server";
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        while (out != null){
            try{
                out.writeUTF(name+scan.nextLine());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        try{
            show.showIntro();
            while(true){
                show.showNav();
                NoticeBoardEnum selected = func.noticeBoardSelector();
                try{
                    switch(selected){
                        case EXIT:
                            func.chooseExit();
                            break;
                        case LIST:
                            func.chooseList();
                            break;
                        case DELETE:
                            func.chooseDelete();
                            break;
                        case DESCRIPTION:
                            func.chooseDescription();
                            break;
                        case REGISTRATION:
                            func.chooseRegistration();
                            break;
                    }
                }catch (NullPointerException e){
                    out.writeUTF("This number is not Exist please check your choose");
                    continue;
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
