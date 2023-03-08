package kr.codesquad.ladder.view;

public class ConsoleOutput {
    public ConsoleOutput() {
    }

    public static void askParticipantsNumber() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public static void askParticipantsName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }
}
