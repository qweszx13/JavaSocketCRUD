package KimDonggyu.MainPackage.Resources;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class BoardStraw{
    public DataInputStream in;
    public DataOutputStream out;

    public BoardStraw(DataInputStream read,DataOutputStream write){
        this.in = read;
        this.out = write;
    }
    public void sendMessage(String num){
        try {
            out.writeUTF(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String recieveMessage(){
        String num="";
        try {
            num = in.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }

}
