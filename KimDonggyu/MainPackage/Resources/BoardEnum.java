package KimDonggyu.MainPackage.Resources;

public enum BoardEnum {
    EXIT(0, "종료"),
    LIST(1, "목록"),
    REGISTRATION(2, "등록"),
    DESCRIPTION(3, "내용"),
    DELETE(4, "삭제");


    private final int num;
    private final String name;

    BoardEnum(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }


}
