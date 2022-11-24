package KimDonggyu.MainPackage.Server;

import KimDonggyu.MainPackage.Resources.BoardStraw;
import KimDonggyu.MainPackage.Resources.BoardUI;
import KimDonggyu.MainPackage.Resources.BoardEnum;
import KimDonggyu.MainPackage.Resources.BoardFuction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class
BoardEachSocket extends Thread{
    Socket mySocket = null;
    boolean boardSwitch = true;
    BoardStraw straw;
    BoardUI ui;
    BoardFuction func;

    public BoardEachSocket(Socket socket) {
        try{
            mySocket = socket;
            straw = new BoardStraw(new DataInputStream(socket.getInputStream()), new DataOutputStream(socket.getOutputStream()));
            ui = new BoardUI();
            func = new BoardFuction(straw);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        System.out.println(mySocket.getInetAddress()+"님 서버 접속");
            straw.sendMessage(ui.showIntro());
            while(!mySocket.isClosed()) {
                straw.sendMessage(ui.showNav());
                try{
                    BoardEnum selected = boardSelector();
                    switch (selected) {
                        case EXIT:
                            straw.sendMessage(ui.useLine("Server Down"));
                            boardSwitch = false;
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
                        default:
                            straw.sendMessage(ui.useLine("That's unexpected Number"));
                            continue;
                    }
                }catch (NullPointerException e){
                    straw.sendMessage(ui.useLine("Not Exist List"));
                    e.printStackTrace();
                    continue;
                } catch (Exception e) {
                    straw.sendMessage(ui.useLine("Error"));
                    e.printStackTrace();
                }
            }
            try {
                straw.in.close();
                straw.out.close();
                mySocket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
    }
    public BoardEnum boardSelector()throws Exception{
        int result;
        result = Integer.parseInt(straw.in.readUTF());
        for(BoardEnum x : BoardEnum.values()){
            if(x.getNum() == result){
                straw.out.writeUTF(ui.showEachExplanation(result));
                return x;
            }
        }
        return null;
    }
}
