package kr.codesquad;

public class LadderConsoleWriter implements LadderWriter {

    @Override
    public void writeNamesOfPeopleIntro() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
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

    @Override
    public void writeNamesOfPeople(Ladder ladder) {
        System.out.println(ladder.getNamesOfPeople());
    }
}
