package KimDonggyu;

import org.json.simple.JSONObject;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class NoticeBoard {
    Scanner scan = new Scanner(System.in);
    NoticeBoardShowContents show = new NoticeBoardShowContents();
    static private int num;// 리스트 넘버링
    static private LinkedList<JSONObject> myList = new LinkedList<>();

    public NoticeBoardEnum noticeBoardSelector(){
        int result;
        try{
           result = Integer.parseInt(scan.nextLine());
           for(NoticeBoardEnum x : NoticeBoardEnum.values()){
               if(x.getNum() == result){
                   show.showEachExplanation(result);
                   return x;
               }
           }
        }catch (Exception e){
            show.showError(e);
        }
        return null;
    }

   public void chooseExit(){
       System.exit(0);
   }
   public void chooseList(){
       if(!myList.isEmpty()){
           int count = 1;
           for(JSONObject x: myList){
               JSONObject inf = (JSONObject) x.get("msg");
               System.out.printf("%-7d|%-12s|%-15s|%-100s",count++,inf.get("title"),inf.get("writer"),inf.get("date"));
               System.out.println();
           }
           count = 1;
       }else{
           System.out.println("--------------------------------NO Post Anyone--------------------------------");
       }
   }

   public void chooseRegistration(){
        System.out.print("Title>>");
        String title = scan.nextLine();
        System.out.print("Description>>");
        String description = scan.nextLine();
        System.out.print("Writer>>");
        String writer = scan.nextLine();
        jsonadd(title,description,writer);
    }
   public void chooseDelete(){
        if(!myList.isEmpty()){
            while(true){
                try{
                    chooseList();
                    int num = Integer.parseInt(scan.nextLine());
                    myList.remove(num-1);
                    System.out.println("Delete Complete");
                    return;
                }catch (IndexOutOfBoundsException e){
                    System.out.println("That is not Exist");
                    continue;
                }catch (NumberFormatException e){
                    System.out.println("Wrong Input");
                    continue;
                }
            }
        }else{
            System.out.println("--------------------------------NO Post Anyone--------------------------------");
            return;
        }

   }
   public  void chooseDescription(){
       try {
           if(!myList.isEmpty()){
               chooseList();
               System.out.println("Which Content do you want see");
               int num = Integer.parseInt(scan.nextLine());
               JSONObject inf = (JSONObject) myList.get(num-1).get("msg");
               System.out.println("----------------------------D E S C R I P T I O N----------------------------");
               System.out.println(inf.get("description"));
               System.out.println("--------------------------------==============-------------------------------");
           }else{
               System.out.println("--------------------------------NO Post Anyone--------------------------------");
           }
       }catch (IndexOutOfBoundsException e){
           System.out.println("----------------------------That is not Exist Post---------------------------");
           return;
       }
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

}
