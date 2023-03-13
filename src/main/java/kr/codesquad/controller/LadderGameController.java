package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderHeight;
import kr.codesquad.domain.Player;
import kr.codesquad.domain.Result;

public class LadderGameController {
    private final InputOutputController ioController;
    private final Player player;
    private final LadderHeight ladderHeight;
    private final Result result;

    public LadderGameController() {
        this.ioController = new InputOutputController();
        this.player = ioController.getName();
        this.result = ioController.getResult(player.getNameList().size());
        this.ladderHeight = ioController.getHeight();
    }

    public void startLadderGame() {
        Ladder ladder = new Ladder(player.getNameList(), ladderHeight.getLadderHeight());
        ioController.printLadder(ladder, result);
//        ioController.getExcutionResult();
    }
}