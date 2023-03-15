package kr.codesquad.domain;

import java.util.List;

public class Ladder {
    private final String MINIMUM_HEIGHT_ERROR = "사다리 높이는 1부터 입력 가능합니다.";
    private final int MINIMUM_HEIGHT = 1;
    private List<Line> lines;

    public Ladder(int maxHeight, int playersCount) {
//        validateRandomLine(lines);         // 열 검사(column에 최소 1개 이상의 라인 생성)
//        validateContinuousLine(lines);     // 행 검사(row의 line이 연속되는 것 제한)
        validateMinimumHeight(maxHeight);
        this.lines = generateLadder(maxHeight, playersCount);
    }


    private void validateMinimumHeight(int ladderHeight) {
        if (MINIMUM_HEIGHT > ladderHeight) {
            throw new IllegalArgumentException(MINIMUM_HEIGHT_ERROR);
        }
    }

    private List<Line> generateLadder(int ladderHeight, int countOfPlayers) {
        return lines;
    }

//    private void validateRandomLine(List<Line> ladderLines) {
//
//    }
//
//    private void validateContinuousLine(List<Line> ladderLines) {
//
//    }
}
