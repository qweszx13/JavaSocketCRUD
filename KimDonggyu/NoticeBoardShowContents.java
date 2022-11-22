package KimDonggyu;

import java.util.Scanner;

public class NoticeBoardShowContents {
    Scanner scan = new Scanner(System.in);

    public static void print(String num){
        System.out.println(num);
    }

    public static String line="▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬";

    public void showIntro(){
        //인트로 웰컴 부분
        print(line);
        print(""+'\t'+'\t'+'\t'+'\t'+'\t'+'\t'+'\t'+"\uD81A\uDC7C.\uD81A\uDD23\uD81A\uDD67\uD80C\uDEFC\uD80C\uDF4AWellcome\uD81A\uDC7C.\uD81A\uDD23\uD81A\uDD67\uD80C\uDEFC\uD80C\uDF4A");
    }
    public void showNav(){
        print(line);
        print(""+'\t'+'\t'+'\t'+'\t'+'\t'+"1.목록"+'\t'+"2.등록"+'\t'+"3.내용"+'\t'+"4.삭제"+'\t'+"0.종료"+'\t');
        print(line);
    }
    public void showEachExplanation(int i){
        String[] explanationArr = new String[NoticeBoardEnum.values().length];
        explanationArr[NoticeBoardEnum.EXIT.getNum()] = "Choose.0 CLOSE PROJECT";
        explanationArr[NoticeBoardEnum.LIST.getNum()] = "Choose.1 Show List";
        explanationArr[NoticeBoardEnum.REGISTRATION.getNum()] = "Choose.2 please put in Title,Description,Writer";
        explanationArr[NoticeBoardEnum.DESCRIPTION.getNum()] = "Choose.3 Please select the list you want";
        explanationArr[NoticeBoardEnum.DELETE.getNum()] = "Choose.4 Please select a list to delete";
        print(explanationArr[i]);
    }
    public void showContinue(){
        print("");
        print(""+'\t'+'\t'+'\t'+'\t'+"  "+"═════════•°• 계속 하시려면 Enter •°•═════════");
        scan.nextLine();
    }

    public void showError(Exception e){
        print(e.getMessage());
        print("정확한 값을 넣어주세요");
    }

}
