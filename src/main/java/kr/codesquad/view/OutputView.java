package kr.codesquad.view;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Players;

public class OutputView {

    public void printLadder(Ladder ladder) {
        System.out.println(ladder.toString());
    }

    public void printPlayerNames(Players players) {
        System.out.println(players.toString());
    }

}
