package KimHyungho;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class TestPrac {

    private String title;
    private String content;
    private String writer;

    String pattern = "MMM dd, yyyy, h:mm:ss a";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("en", "US"));

    private String date = simpleDateFormat.format(new Date());

    Scanner scr = new Scanner(System.in);

    public TestPrac() {

        System.out.print("제목>");
        this.title = scr.nextLine();

        System.out.print("내용>");
        this.content = scr.nextLine();

        System.out.print("작성자>");
        this.writer = scr.nextLine();

        System.out.println("글이 정상적으로 추가 되었습니다.");
    }

    public void getPrint() {
        System.out.println(title + "\t" + writer + "\t" + date);
    }

    public void getPrintContent() {
        System.out.println(title + "\t" + content + "\t" + writer + "\t" + date);
    }

}

public class CBoard {

    private List<TestPrac> list = new ArrayList<>();
    Scanner scr = new Scanner(System.in);

    public void text() {
        System.out.println("============================");
        System.out.println("번호 제목 작성자    　작성일");
        System.out.println("----------------------------");
    }

    public void quest() {
        System.out.print("1.목록   2.등록   3.내용   4.삭제   0.종료>");
    }

    public void list() {
        int count = 1;
        if (list == null) {
            return;
        }
        text();

        for (Iterator<TestPrac> itr = list.iterator(); itr.hasNext();) {
            System.out.print(count + "\t");
            itr.next().getPrint();
            count++;
        }
    }

    public void create() {
        list.add(new TestPrac());
        quest();
    }

    public void content() {
        list();
        System.out.print("위에 게시판 번호중 하나를 입력하세요.>>");
        int inputNumber = scr.nextInt();
        text();
        System.out.print(inputNumber + "\t");
        list.get(--inputNumber).getPrintContent();
        quest();
    }

    public void remove() {
        list();
        System.out.print("제거 할 게시글의 번호를 입력하세요.>>");
        int number = scr.nextInt();

        list.remove(number - 1);

        System.out.println("해당 게시판을 삭제하였습니다.");
        quest();
    }

    public void start() {

        text();
        quest();

        while (true) {
            int inputNum = scr.nextInt();
            switch (inputNum) {

                // 게시판 종료
                case 0:
                    scr.close();
                    System.out.println("게시판이 종료됩니다.");
                    break;

                // 목록 출력
                case 1:
                    text();
                    // 내용 == null이면 quest()만 출력 후 다시 처음부터
                    // null이 아니면 등록된 내용의 번호 제목 작성자 작성일 출력
                    quest();
                    break;

                // 정보 등록
                case 2:
                    create();
                    // 스캐너에서 정보를 입력받아 list에 저장
                    break;

                // 내용 출력
                case 3:
                    content();
                    // 등록된 내용의 번호 제목 내용 작성자 작성일 출력
                    break;

                // 내용 삭제
                case 4:
                    remove();
            }
        }

    }
}

class BoardTest {
    public static void main(String[] args) {
        // 객체 생성하여 함수 모두 종합하고 main에 넣기
        CBoard cboard = new CBoard();
        cboard.start();
    }
}
