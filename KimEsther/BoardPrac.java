package KimEsther;

import java.io.IOException;
import java.util.*;

public class BoardPrac {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        Board board = new Board();

        try {
            while (true) {
                System.out.println("\n번호     제목\t\t작성자\t\t    작성일");
                System.out.println("======================================================");
                System.out.print("1.목록\t 2.등록\t 3.내용\t 4.삭제\t 0.종료 ");
                int num = sc.nextInt();
                if (num == 1) {
                    board.getBoardList();
                } else if (num == 2) {
                    board.InsertContents();
                } else if (num == 3) {
                    board.ShowContents();
                } else if (num == 4) {
                    board.DeleteContents();
                } else if (num == 0) {
                    System.out.println("종료합니다.");
                    break;
                } else {
                    System.out.println("잘못된입력입니다. 다시 입력해주세요.");
                }

            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("무언가 잘못되었음을 못 느끼나요? 종료!");
        }
    }

}

