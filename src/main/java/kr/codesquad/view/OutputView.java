package kr.codesquad.view;

import kr.codesquad.domain.LadderResult;

public class OutputView {

    public void printLadderGameShape(LadderResult ladderResult){
        StringBuilder ladderShape = new StringBuilder();
        OutputLadderShape outputLadderShape = new OutputLadderShape(ladderResult);
        ladderShape.append(outputLadderShape.getPlayerNameLine()).append(outputLadderShape.getLadderLine());
        System.out.println(ladderShape);
    }

}
