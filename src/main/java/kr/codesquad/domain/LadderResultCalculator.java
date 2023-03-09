package kr.codesquad.domain;

import java.util.List;

public class LadderResultCalculator {

    public void calculator(List<LineInfo> linesStateInfo,
        LadderResultRepository ladderResultRepository) {
        int columnLength = linesStateInfo.get(0).size();
        for (int j = 0; j < columnLength + 1; j++) {
            moveAndSaveResult(ladderResultRepository, linesStateInfo, j);
        }
    }

    private void moveAndSaveResult(LadderResultRepository ladderResultRepository, List<LineInfo> linesStateInfo,
        int position) {
        int resultNum = position;
        for (LineInfo lineInfo : linesStateInfo) {
            resultNum = lineInfo.move(resultNum);
        }
        ladderResultRepository.put(position, resultNum);
    }
}
