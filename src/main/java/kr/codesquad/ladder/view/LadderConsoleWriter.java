package kr.codesquad.ladder.view;

import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.Names;

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
    public void write(Ladder ladder) {
        write(ladder.toString());
    }

    @Override
    public void write(Names names) {
        write(names.toString());
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
