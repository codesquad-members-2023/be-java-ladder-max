package kr.codesquad;

public class Ladder {
    // "|" 개수: participantNumber
    // "-", " " 개수: participantNumber - 1, "-" 혹은 " "은 둘 중 하나로 랜덤 출력한다.

    public Ladder() {
    }

    public void printVerticalBar() {
        System.out.println("|");
    }

    public void printMinusSign() {
        System.out.println("-");
    }

    public void printBlank() {
        System.out.println(" ");
    }
}
