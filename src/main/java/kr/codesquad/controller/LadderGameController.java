package kr.codesquad.controller;

import kr.codesquad.controller.dto.LadderInputDto;
import kr.codesquad.controller.dto.LadderOutputDto;
import kr.codesquad.domain.LadderResult;
import kr.codesquad.service.LadderGame;
import kr.codesquad.view.Screen;

import java.util.List;
import java.util.Optional;

public class LadderGameController {
    private final LadderGame ladderGame;
    private final Screen screen;

    public LadderGameController(LadderGame ladderGame, Screen screen) {
        this.ladderGame = ladderGame;
        this.screen = screen;
    }

    public void run() {
        final List<String> playerNames = inputPlayerNames();
        final int height = inputLadderHeight();
        final List<String> goals = inputGoals();
        final LadderOutputDto ladderOutputDto = ladderGame.play(new LadderInputDto(playerNames, height, goals));

        screen.printLadder(playerNames, ladderOutputDto.getLadderShape(), goals);
        showWinningResult(ladderOutputDto.getLadderResult());
    }

    private void showWinningResult(LadderResult ladderResult) {
        screen.printResult(ladderResult.getAllResults());
    }

    private List<String> inputGoals() {
        Optional<List<String>> goals = Optional.empty();

        while (goals.isEmpty()) {
            goals = screen.inputGoals();
        }

        return goals.get();
    }

    private int inputLadderHeight() {
        Optional<Integer> ladderHeight = Optional.empty();

        while (ladderHeight.isEmpty()) {
            ladderHeight = screen.inputLadderHeight();
        }

        return ladderHeight.get();
    }

    private List<String> inputPlayerNames() {
        Optional<List<String>> playerNames = Optional.empty();

        while (playerNames.isEmpty()) {
            playerNames = screen.inputPlayerNames();
        }

        return playerNames.get();
    }
}
