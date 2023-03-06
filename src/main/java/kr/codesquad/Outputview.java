package kr.codesquad;

public class Outputview {
    public static String printPeopleFormat() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return InputView.inputNumber();
    }

    public static String printLadderHeightFormat() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return InputView.inputNumber();
    }
}
