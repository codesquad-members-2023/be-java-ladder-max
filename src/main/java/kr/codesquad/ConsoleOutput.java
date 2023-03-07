package kr.codesquad;

public class ConsoleOutput {

    public static void printInputPersonIntro() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public static void printInputMaximumLadderHeightIntro() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printInvalidInputNumber(String message) {
        System.out.println(message);
        System.out.println();
    }

    public static void printLadderBoard(String ladder) {
        System.out.println(ladder);
    }
}
