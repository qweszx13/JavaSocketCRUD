package KimDonggyu;

import java.util.Scanner;
import org.json.simple.JSONObject;//json 객체 생성
import org.json.simple.parser.JSONParser;//json 객체 파싱
import org.json.simple.parser.ParseException;//예외 처리


public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        RunBoard runB = new RunBoard();
        String title = "";
        String description = "";
        String writer = "";
        runB.showMainTitle();
        while (true){
            runB.showNav();
            System.out.print("Choose*•.¸*•.¸*•.¸*•.¸*•.¸*•.¸*•.¸");
            int select = scan.nextInt();
            scan.nextLine();
            switch (select){
                case 1: runB.showEachExplanation(select);
                    runB.showConTitle();
                    runB.controlShowList();;
                    runB.showContinue();
                    break;
                case 2: runB.showEachExplanation(select);
                    System.out.print("제목>>");
                    title = scan.nextLine();
                    System.out.print("내용>>");
                    description = scan.nextLine();
                    System.out.print("작성자>>");
                    writer = scan.nextLine();
                    runB.jsonadd(title,description,writer);
                    runB.showContinue();
                    break;
                case 3: runB.showEachExplanation(select);
                    runB.showConTitle();
                    runB.controlShowList();
                    runB.controlDescription(scan.nextInt());
                    scan.nextLine();
                    runB.showContinue();
                    break;
                case 4: runB.showEachExplanation(select);
                    runB.controlShowList();
                    runB.controlDelete(scan.nextInt());
                    scan.nextLine();
                    runB.showContinue();
                    break;
                case 0: runB.showEachExplanation(select);
                    runB.showContinue();
                    return;
                default: System.out.println("값은 제대로 넣기!");
                    break;
            }
        }
    }




}
