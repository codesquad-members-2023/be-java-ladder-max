package kr.codesquad.view;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Line;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    public void printInputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void printInputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printLineResult(Line line) {
        System.out.println(line.getLine());
    }

    public void printLadderResult(Ladder ladder) {
        System.out.println("실행결과");
        ladder.getLadder().stream()
                .map(line -> String.join("", line.getLine()))
                .forEach(System.out::println);
    }
}