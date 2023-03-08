package kr.codesquad.domain;

import java.util.List;

public class LadderResultCalculator {

    public void calculator(List<List<Boolean>> linesStateInfo,
        LadderResultRepository ladderResultRepository) {
        int columnLength = linesStateInfo.get(0).size();
        for (int j = 0; j < columnLength + 1; j++) {
            moveAndSaveResult(ladderResultRepository, linesStateInfo, columnLength, j);
        }
    }

    private void moveAndSaveResult(LadderResultRepository ladderResultRepository, List<List<Boolean>> linesStateInfo,
        int columnLength, int position) {
        int resultNum = position;
        for (List<Boolean> oneRowStateInfo : linesStateInfo) {
            if (canMoveLeft(resultNum, oneRowStateInfo)) {
                resultNum = resultNum - 1;
            } else if (canMoveRight(columnLength, resultNum, oneRowStateInfo)) {
                resultNum = resultNum + 1;
            }
        }
        ladderResultRepository.put(position, resultNum);
    }

    private static boolean canMoveLeft(int resultNum, List<Boolean> oneRowStateInfo) {
        return resultNum > 0 && oneRowStateInfo.get(resultNum - 1);
    }

    private static boolean canMoveRight(int columnLength, int resultNum, List<Boolean> oneRowStateInfo) {
        return resultNum < columnLength && oneRowStateInfo.get(resultNum);
    }
}
