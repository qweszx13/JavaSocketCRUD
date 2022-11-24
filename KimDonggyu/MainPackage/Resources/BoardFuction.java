package KimDonggyu.MainPackage.Resources;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

public class BoardFuction {
    static private int num;// 리스트 넘버링
    static private LinkedList<JSONObject> myList = new LinkedList<>();
    BoardStraw straw;
    BoardUI ui = new BoardUI();

    public BoardFuction(BoardStraw straw){
        this.straw = straw;
    }


    public void  chooseList(){
        controlShowList();
    }

    public void chooseDelete() {
        int deleteNum = 0;
        controlShowList();
        straw.sendMessage(ui.useLine("Which want Delete"));
        deleteNum = Integer.parseInt(straw.recieveMessage());
        controlDelete(deleteNum);

    }

    public void chooseDescription() {
        int descriptionNum = 0;
        controlShowList();
        straw.sendMessage(ui.useLine("Which want Description"));
        descriptionNum = Integer.parseInt(straw.recieveMessage());
        controlDescription(descriptionNum);
    }

    public void chooseRegistration() {
        String title,description,writer;
        straw.sendMessage("제목 입력>>");
        ui.useLine("");
        title = straw.recieveMessage();
        straw.sendMessage("내용 입력>>");
        ui.useLine("");
        description = straw.recieveMessage();
        straw.sendMessage("작성자 입력>>");
        ui.useLine("");
        writer = straw.recieveMessage();
        jsonadd(title,description,writer);
        straw.sendMessage("추가 완료");
    }

    public void jsonadd(String title,String description,String writer) {
        JSONObject inner = new JSONObject();//Json inner 부분
        inner.put("num",  this.num); // key는 "num", value는 순서
        inner.put("title", title); // key는 "title", value는 제목
        inner.put("description", description); // key는 "description", value는 내용
        inner.put("writer", writer); // key는 "writer", value는 작성자
        inner.put("date",new Date());

        JSONObject outer = new JSONObject();//json outer 부분
        outer.put("msg", inner);
        outer.put("type", "insert");

        String json = outer.toJSONString(); // JSON객체를 String으로 변환
        myList.add(outer);

        System.out.println(json);

        this.num++;//number 리스트넘버 증가
    }

    public void controlShowList(){
        if(!myList.isEmpty()){
            int counting = 1;
            for(JSONObject x: myList){
                JSONObject inf = (JSONObject) x.get("msg");
                straw.sendMessage(counting+"|"+'\t'+'\t'+inf.get("title")+"|"+'\t'+'\t'+inf.get("writer")+"|"+'\t'+'\t'+inf.get("date"));
                counting++;
            }
        }else{
            straw.sendMessage(ui.useLine("NO Post"));
        }

    }
    public void controlDelete(int num){
        try{
            myList.remove(num-1);
            straw.sendMessage(ui.useLine("Delete Success"));
            return;
        }catch (IndexOutOfBoundsException e){
            straw.sendMessage(ui.useLine("That's Not ExistList"));
            return;
        }
    }
    public void controlDescription(int num){
        try {
            JSONObject inf = (JSONObject) myList.get(num-1).get("msg");
            straw.sendMessage("◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤");
            straw.sendMessage((String)inf.get("description"));
            straw.sendMessage("◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤");
        }catch (IndexOutOfBoundsException e){
            straw.sendMessage(ui.useLine("That's Not ExistList"));
            return;
        }
    }


}
