package kr.codesquad;

public class LadderConsoleWriter implements LadderWriter {

    @Override
    public void writeNumberOfPeopleIntro() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    @Override
    public void writeMaximumLadderHeightIntro() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    @Override
    public void writeInvalidReadNumber(String message) {
        System.out.println(message);
        System.out.println();
    }

    @Override
    public void writeLadder(String ladder) {
        System.out.println(ladder);
    }
}
