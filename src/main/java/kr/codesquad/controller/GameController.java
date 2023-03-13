package kr.codesquad.controller;

import kr.codesquad.domain.*;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class GameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void runLadderGame() throws IOException {
        PlayerGroup playerGroup = new PlayerGroup(inputView.inputPlayerNames());
        DestinationGroup destinationGroup = new DestinationGroup(inputView.inputDestinationNames());
        Ladder ladder = new Ladder(playerGroup.getPlayerCount(), inputView.inputLadderHeight());
        ResultGroup resultGroup = makeResultGroup(playerGroup, destinationGroup, ladder);
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
