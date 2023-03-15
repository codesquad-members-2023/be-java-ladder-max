package kr.codesquad.view;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Players;
import kr.codesquad.domain.Results;

public class OutputView {
    public void printLadder(Ladder ladder, Players player, Results result) {
        System.out.println(player+""+ladder+""+ result);
    }
}
