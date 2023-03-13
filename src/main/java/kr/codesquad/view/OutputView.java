package kr.codesquad.view;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Result;

public class OutputView {
    public void printLadder(Ladder ladder, Result result) {
        System.out.println(ladder+"\n"+ result);
    }
}
