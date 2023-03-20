package kr.codesquad.controller;

import kr.codesquad.domain.*;
import kr.codesquad.util.ExecutionResultGenerator;

public class LadderGameController {
    private final InputOutputController ioController;
    private final Ladder ladder;

    public LadderGameController() {
        this.ioController = new InputOutputController();
        this.ladder  = new Ladder();
    }

    public void startLadderGame(){
        Players players = new Players(ioController.getPlayers());
        int ladderHeight = ioController.getHeight();
        Results results = new Results(ioController.getResults(players.getCountOfPlayers()));
        ladder.createValidLadder(players.getCountOfPlayers(), ladderHeight);
        ioController.printLadder(ladder, players, results);
        ExecutionResultGenerator executionResultGenerator = new ExecutionResultGenerator(ladder, players, results);
        ioController.getExecutionResult(executionResultGenerator.getResultMap());
    }
}