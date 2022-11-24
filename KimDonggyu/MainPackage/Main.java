package KimDonggyu.MainPackage;

import KimDonggyu.MainPackage.Server.BoardServer;

public class Main {
    public static void main(String[] args) {
        BoardServer bm = new BoardServer();
        bm.run();
    }
}
