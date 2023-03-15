package kr.codesquad.controller;

import kr.codesquad.controller.dto.LadderInputDto;
import kr.codesquad.controller.dto.LadderOutputDto;
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
        final LadderInputDto ladderInputDto = new LadderInputDto(playerNames, height);

        final LadderOutputDto ladderOutputDto = ladderGame.play(ladderInputDto);

        screen.printLadder(playerNames, ladderOutputDto.getLadderShape());
        screen.printResult(ladderOutputDto.getLadderResult());
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
