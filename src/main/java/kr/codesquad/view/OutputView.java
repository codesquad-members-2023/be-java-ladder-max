package kr.codesquad.view;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Line;
import kr.codesquad.domain.Players;

public class OutputView {
    private static final String INPUT_PLAYERS_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_RESULT_MESSAGE = "실행 결과";

    public void printInputPlayers() {
        System.out.println(INPUT_PLAYERS_MESSAGE);
    }

    public void printInputHeight() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
    }

    public void printLadderResult(Ladder ladder, Players players) {
        System.out.println(LADDER_RESULT_MESSAGE);
        printPlayers(players);
        for (int i = 0; i < ladder.getSize(); i++) {
            printOneLine(ladder.getOneLine(i));
        }
    }

    public void printOneLine(Line line) {
        StringBuilder lineString = new StringBuilder();
        for (int i = 0; i < line.getSize(); i++) {
            lineString.append(line.getLine().get(i));
        }
        System.out.println(lineString);
    }

    public void printPlayers(Players players) {
        System.out.println(players.getNames());
    }
}