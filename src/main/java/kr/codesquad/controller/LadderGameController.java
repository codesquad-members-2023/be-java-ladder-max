package kr.codesquad.controller;

import kr.codesquad.domain.*;
import kr.codesquad.util.ExecutionResultGenerator;

public class LadderGameController {
    private final InputOutputController ioController;

    public LadderGameController() {
        this.ioController = new InputOutputController();
    }

    public void startLadderGame(){
        Players players = new Players(ioController.getPlayers());
        int ladderHeight = ioController.getHeight();
        Results results = new Results(ioController.getResults(players.getCountOfPlayers()));
        Ladder ladder = new Ladder(players.getCountOfPlayers(), ladderHeight);
        ExecutionResultGenerator executionResultGenerator = new ExecutionResultGenerator(ladder, players, results);

        ioController.printLadder(ladder, players, results);
        ioController.getExecutionResult(executionResultGenerator.getResultMap());
    }
}