package kr.codesquad.view;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.PlayerGroup;

public class OutputView {

    public void printLadder(Ladder ladder) {
        System.out.println(ladder.toString());
    }

    public void printPlayerNames(PlayerGroup playerGroup) {
        System.out.println(playerGroup.toString());
    }

}
