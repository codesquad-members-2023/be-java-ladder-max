package kr.codesquad.controller;

import kr.codesquad.domain.destination.DestinationGroup;
import kr.codesquad.domain.ladder.Ladder;
import kr.codesquad.domain.player.PlayerGroup;
import kr.codesquad.domain.result.Result;
import kr.codesquad.domain.result.ResultGroup;
import kr.codesquad.exception.GameProgressException;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class GameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private PlayerGroup playerGroup;
    private DestinationGroup destinationGroup;
    private Ladder ladder;
    private ResultGroup resultGroup;

    public void runLadderGame() throws IOException, GameProgressException {
        System.out.println("-----[사다리 게임 시작]-----");
        playerGroup = new PlayerGroup(inputView.inputPlayerNames());

        while(true) {
            try {
                destinationGroup = new DestinationGroup(inputView.inputDestinationNames(), playerGroup.getPlayerCount());
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage() + System.lineSeparator());
                continue;
            }
            break;
        }

        while(true) {
            try {
                ladder = new Ladder(playerGroup.getPlayerCount(), inputView.inputLadderHeight());
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage() + System.lineSeparator());
                continue;
            }
            break;
        }

        resultGroup = makeResultGroup(playerGroup, destinationGroup, ladder);
        outputView.printPlayerNames(playerGroup);
        outputView.printLadder(ladder);
        outputView.printDestination(destinationGroup);

        while(true) {
            try {
                outputView.printResult(resultGroup, inputView.inputSelectPlayer());
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage() + System.lineSeparator());
            }
        }
    }

    private ResultGroup makeResultGroup(PlayerGroup playerGroup, DestinationGroup destinationGroup, Ladder ladder) {
        ResultGroup resultGroup = new ResultGroup();
        int playerCount = playerGroup.getPlayerCount();

        for(int i = 0; i < playerCount; i++) {
            int resultIndex = ladder.climbDownLadder(i);
            resultGroup.add(new Result(playerGroup.getName(i), destinationGroup.getName(resultIndex)));
        }

        return resultGroup;
    }

}
