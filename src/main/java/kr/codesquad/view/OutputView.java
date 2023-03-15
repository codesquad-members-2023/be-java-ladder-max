package kr.codesquad.view;

import kr.codesquad.domain.destination.DestinationGroup;
import kr.codesquad.domain.ladder.Ladder;
import kr.codesquad.domain.player.PlayerGroup;
import kr.codesquad.domain.result.ResultGroup;
import kr.codesquad.exception.GameProgressException;

public class OutputView {

    public void printLadder(Ladder ladder) {
        System.out.print(ladder);
    }

    public void printPlayerNames(PlayerGroup playerGroup) {
        System.out.println(playerGroup);
    }

    public void printDestination(DestinationGroup destinationGroup) {
        System.out.println(destinationGroup);
    }

    public void printResult(ResultGroup resultGroup, String playerName) throws GameProgressException {
        System.out.println(resultGroup.getResult(playerName));
    }

}
