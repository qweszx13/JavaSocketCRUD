package KimDonggyu;

import org.json.simple.JSONObject;

import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;


public class NoticeBoard1111 {
    static private int num;// 리스트 넘버링
    static private LinkedList<JSONObject> myList = new LinkedList<>();
    Scanner scan = new Scanner(System.in);

    public void run(){
        String title = "";
        String description = "";
        String writer = "";

        showMainTitle();
        while (true){
            showNav();
            System.out.print("Choose*•.¸*•.¸*•.¸*•.¸*•.¸*•.¸*•.¸");
            int select = scan.nextInt();
            scan.nextLine();
            switch (select){
                case 1: showEachExplanation(select);
                    showConTitle();
                    controlShowList();;
                    showContinue();
                    break;
                case 2: showEachExplanation(select);
                    System.out.print("제목>>");
                    title = scan.nextLine();
                    System.out.print("내용>>");
                    description = scan.nextLine();
                    System.out.print("작성자>>");
                    writer = scan.nextLine();
                    jsonadd(title,description,writer);
                    showContinue();
                    break;
                case 3: showEachExplanation(select);
                    showConTitle();
                    controlShowList();
                    controlDescription(scan.nextInt());
                    scan.nextLine();
                    showContinue();
                    break;
                case 4: showEachExplanation(select);
                    controlShowList();
                    controlDelete(scan.nextInt());
                    scan.nextLine();
                    showContinue();
                    break;
                case 0: showEachExplanation(select);
                    showContinue();
                    return;
                default: System.out.println("값은 제대로 넣기!");
                    break;
            }
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

    public void controlDelete(int num){
        //객체를 찾아서 지우도록 수정
        try{
            myList.remove(num);
            System.out.println(""+'\t'+'\t'+'\t'+'\t'+"  "+"▂▃▅▇█▓▒░۩۞۩ 게시글을 삭제 하였습니다 ۩۞۩░▒▓█▇▅▃▂");
            return;
        }catch (IndexOutOfBoundsException e){
            System.out.println(""+'\t'+'\t'+'\t'+'\t'+"  "+"▂▃▅▇█▓▒░۩۞۩ 존재하지 않는 게시판입니다 ۩۞۩░▒▓█▇▅▃▂");
            return;
        }
    }

    public void controlDescription(int num){
        try {
            JSONObject inf = (JSONObject) myList.get(num).get("msg");
            System.out.println("◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤");
            System.out.println(inf.get("description"));
            System.out.println("◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤◢◣◥◤");
        }catch (IndexOutOfBoundsException e){
            System.out.println(""+'\t'+'\t'+'\t'+'\t'+"  "+"▂▃▅▇█▓▒░۩۞۩ 존재하지 않는 게시판입니다 ۩۞۩░▒▓█▇▅▃▂");
            return;
        }
    }

    public void controlShowList(){
        if(!myList.isEmpty()){
            for(JSONObject x: myList){
                JSONObject inf = (JSONObject) x.get("msg");
                System.out.printf("%-7d|%-12s|%-15s|%-100s",inf.get("num"),inf.get("title"),inf.get("writer"),inf.get("date"));
                System.out.println();
            }
        }else{
            System.out.println("▂▃▅▇█▓▒░۩۞۩ 아직 아무 게시글도 존재하지않아요 ۩۞۩░▒▓█▇▅▃▂");
        }

    }

    public void showConTitle(){
        System.out.println("▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬");
        System.out.println("번호\uD80C\uDC83◌\uD80C\uDE12\uD80D\uDC0D"+'\t'+"제목\uD80C\uDC83◌\uD80C\uDE12\uD80D\uDC0D"+'\t'+'\t'+"작성자\uD80C\uDC83◌\uD80C\uDE12\uD80D\uDC0D"+'\t'+'\t'+"작성일\uD80C\uDC83◌\uD80C\uDE12\uD80D\uDC0D");

    }

    public void showNav(){
        System.out.println("▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬");
        System.out.println(""+'\t'+'\t'+'\t'+'\t'+'\t'+"1.목록"+'\t'+"2.등록"+'\t'+"3.내용"+'\t'+"4.삭제"+'\t'+"0.종료"+'\t');
        System.out.println("▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬");
    }

    public void showMainTitle(){
        System.out.println("▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬");
        System.out.println(""+'\t'+'\t'+'\t'+'\t'+'\t'+'\t'+'\t'+"\uD81A\uDC7C.\uD81A\uDD23\uD81A\uDD67\uD80C\uDEFC\uD80C\uDF4AWellcome\uD81A\uDC7C.\uD81A\uDD23\uD81A\uDD67\uD80C\uDEFC\uD80C\uDF4A");
    }
    public void showEachExplanation(int i){
//        String[] explanationArr = new String[5];
//        explanationArr[0] = "\"\" +\".　　　 ヘ　 ヘ    Bye...Bye..\\n\" +\"　　　/　＼/　＼\\n\" +\"　　／　　　　　ヽ\\n\" +\"　 /　　ㅇ　　 ㅇ　|\\n\" +\"　｜　∪　/￣￣T　|\\n\" + \"　｜∪　 ｜　　|　|\\n\" + \"　 ＼　　｜＿　| ノ\\n\" + \"　 ／　ヽ｜　ヽ|、\\n\" + \"　(　　 |｜　 ||｜\\n\" + \"　|　　 ヽ二二ノ｜\\n\" + \"　|　 L　　　　｣｜\\n\" + \"　ヽ＿ﾉ　　　 (_/\\n\" + \"　　｜　　/　 /\\n\" + \"　　｜　 /　 /\\n\" + \"　　(＿＿)＿_)\\n\")"
        switch (i){
            case 0 :
                System.out.println("" +".　　　 ヘ　 ヘ    Bye...Bye..\n" +"　　　/　＼/　＼\n" +"　　／　　　　　ヽ\n" +"　 /　　ㅇ　　 ㅇ　|\n" +"　｜　∪　/￣￣T　|\n" + "　｜∪　 ｜　　|　|\n" + "　 ＼　　｜＿　| ノ\n" + "　 ／　ヽ｜　ヽ|、\n" + "　(　　 |｜　 ||｜\n" + "　|　　 ヽ二二ノ｜\n" + "　|　 L　　　　｣｜\n" + "　ヽ＿ﾉ　　　 (_/\n" + "　　｜　　/　 /\n" + "　　｜　 /　 /\n" + "　　(＿＿)＿_)\n");
                break;
            case 1 :
                System.out.println("▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬");
                System.out.println(""+'\t'+'\t'+'\t'+'\t'+"  "+"----ۜะะะۣۨ>현 게시판 목록 List<ะะะۜ----");
                break;
            case 2 :
                System.out.println("▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬");
                System.out.println(""+'\t'+'\t'+'\t'+'\t'+"  "+"----ۜะะะۣۨ>제목과 내용 작성자명을 작성해주세요<ะะะۜ----");
                break;
            case 3 :
                System.out.println("▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬");
                System.out.println(""+'\t'+'\t'+'\t'+'\t'+"  "+"----ۜะะะۣۨ>원하시는 게시판의 번호를 입력해주세요<ะะะۜ----");
                break;
            case 4 :
                System.out.println("▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬▬▭▬▭▬▭▬▭▬▭▬▭▬");
                System.out.println(""+'\t'+'\t'+'\t'+'\t'+"  "+"----ۜะะะۣۨ>삭제하실 게시판의 번호를 입력해주세요<ะะะۜ----");
                break;
        }
    }
    public void showContinue(){
        System.out.println();
        System.out.println(""+'\t'+'\t'+'\t'+'\t'+"  "+"═════════•°• 계속 하시려면 Enter •°•═════════");
        scan.nextLine();
    }

}
