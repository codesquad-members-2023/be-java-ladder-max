package kr.codesquad.ladder.view;

import kr.codesquad.ladder.domain.LadderResult;
import kr.codesquad.ladder.domain.LadderResults;
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
    public void writeLadderResultIntro() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    @Override
    public void writeNameForLadderResultIntro(Names names) {
        System.out.println("결과를 보고 싶은 사람은?");
        System.out.printf("all : 전체 결과 보기, 춘식이 : 프로그램 종료, 이름 : %s", names);
        System.out.println();
    }

    @Override
    public void writeLadderResults(LadderResults ladderResults) {
        System.out.println("실행 결과");
        System.out.println(ladderResults);
        System.out.println();
    }

    @Override
    public void writeLadderResult(LadderResult ladderResult) {
        System.out.println("실행 결과");
        System.out.println(ladderResult);
        System.out.println();
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public void writeExitIntro() {
        System.out.println("프로그램을 종료합니다.");
    }
}
