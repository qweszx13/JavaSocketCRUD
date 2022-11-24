package KimDonggyu.MainPackage.Resources;
import java.util.Scanner;

public class BoardUI {
    Scanner scan = new Scanner(System.in);
    String result = "";

    public void printAdd(String num){
        result += num+'\n';
    }
    public String getResult(){
        String copyResult = this.result;
        result = "";
       return copyResult;
    }

    public static String line="▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬";

    public String showIntro(){
        //인트로 웰컴 부분
        printAdd(useLine("Wellcome"));
        return getResult();
    }
    public String showNav(){
        printAdd(line);
        printAdd(""+'\t'+'\t'+'\t'+'\t'+'\t'+"1.목록"+'\t'+"2.등록"+'\t'+"3.내용"+'\t'+"4.삭제"+'\t'+"0.종료"+'\t');
        printAdd(line);
        return getResult();
    }
    public String showEachExplanation(int i){
        String[] explanationArr = new String[BoardEnum.values().length];
        explanationArr[BoardEnum.EXIT.getNum()] = "Choose.0 CLOSE PROJECT";
        explanationArr[BoardEnum.LIST.getNum()] = "Choose.1 Show List";
        explanationArr[BoardEnum.REGISTRATION.getNum()] = "Choose.2 please put in Title,Description,Writer";
        explanationArr[BoardEnum.DESCRIPTION.getNum()] = "Choose.3 Please select the list you want";
        explanationArr[BoardEnum.DELETE.getNum()] = "Choose.4 Please select a list to delete";
        printAdd(explanationArr[i]);
        return getResult();
    }

    public String useLine(String num){
        return"◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣"+num+"◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣";
    }

}
