package kr.codesquad.view;

import kr.codesquad.domain.DestinationGroup;
import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.PlayerGroup;
import kr.codesquad.domain.ResultGroup;

public class OutputView {

    public void printLadder(Ladder ladder) {
        System.out.print(ladder.toString());
    }

    public void printPlayerNames(PlayerGroup playerGroup) {
        System.out.println(playerGroup.toString());
    }

    public void printDestination(DestinationGroup destinationGroup) {
        System.out.println(destinationGroup.toString());
    }

    public void printResult(ResultGroup resultGroup, String playerName) {
        System.out.println(resultGroup.getResult(playerName));
    }

}
