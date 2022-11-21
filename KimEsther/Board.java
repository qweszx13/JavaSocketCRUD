package KimEsther;

import java.text.SimpleDateFormat;
import java.util.*;

class MyBoard {
    private int list;
    private String title;
    private String content;
    private String name;
    private String date;

    public int getList() {
        return list;
    }

    public void setList(int list) {
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        this.title = t;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String c) {
        this.content = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String d) {
        this.date = d;
    }

}

public class Board {
    Scanner sc = new Scanner(System.in);
    List<MyBoard> List = new ArrayList<>();

    public void getBoardList() {
        System.out.println("\n 번호     제목\t\t작성자\t\t    작성일");
        System.out.println("======================================================");
        if (List.isEmpty()) {
            System.out.println(" 아직 아무것도 저장되지 않았습니다.");
        } else {
            for (MyBoard myBoard : List) {
                System.out.println(List.indexOf(myBoard) + 1 + "  | " + myBoard.getTitle() + "\t|" + myBoard.getName()
                        + "\t\t|" + myBoard.getDate());
            }
        }
        System.out.println("------------------------------------------------------");
        System.out.print(" 1.목록\t 2.등록\t 3.내용\t 4.삭제\t 0.종료 ");
        System.out.println();
    }

    public void InsertContents() { // 게시물 등록
        MyBoard mb = new MyBoard();

        System.out.print(" 제목을 입력하세요. >>");
        String title = sc.nextLine();
        System.out.println(" 내용을 입력하세요. >>");
        String con = sc.nextLine();
        System.out.print(" 작성자를 입력하세요. >>");
        String name = sc.nextLine();
        mb.setList(List.indexOf(mb));
        mb.setTitle(title);
        mb.setContent(con);
        mb.setName(name);

        SimpleDateFormat dt = new SimpleDateFormat("MM d, yyyy, HH:mm:ss");
        String date = dt.format(new Date());
        mb.setDate(date);

        List.add(mb);
        System.out.println("******************************************************");
        System.out.println("추가되었습니다.");
        System.out.println("******************************************************");
    }

    public void ShowContents() {// 내용보기
        if (List.isEmpty()) {
            System.out.println(" 게시물이 없습니다");
            return;
        }
        System.out.println("\n 번호     제목             내용\t\t작성자\t\t 작성일");
        System.out.println("======================================================");
        for (MyBoard mB : List) {
            System.out.println( List.indexOf(mB) + 1 + "  |" + mB.getTitle() + "        |" + mB.getContent() + "\t|" + mB.getName()
                    + "\t|" + mB.getDate());
        }

    }

    public void DeleteContents() {
        if (List.isEmpty()) {
            System.out.println(" 게시물이 없습니다");
            return;
        }
        MyBoard mb = new MyBoard();
        System.out.print("지우실 목록 번호를 입력해주세요. >> ");
        int select = sc.nextInt();
        mb = List.get(select - 1);
        List.remove(List.indexOf(mb));// 객체 삭제
        System.out.println( select + "번 목록이 삭제되었습니다.");
    }
}



