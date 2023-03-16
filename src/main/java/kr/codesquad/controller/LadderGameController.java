package kr.codesquad.controller;

import kr.codesquad.controller.dto.LadderInputDto;
import kr.codesquad.controller.dto.LadderOutputDto;
import kr.codesquad.domain.LadderResult;
import kr.codesquad.service.LadderGame;
import kr.codesquad.view.Screen;

import java.util.Collections;
import java.util.List;

public class LadderGameController {
    private static final String EXIT_INPUT = "춘식이";

    private final LadderGame ladderGame;
    private final Screen screen;

    public LadderGameController(LadderGame ladderGame, Screen screen) {
        this.ladderGame = ladderGame;
        this.screen = screen;
    }

    public void run() {
        final List<String> playerNames = readPlayerNames();
        final int height = readLadderHeight();
        final List<String> goals = readGoals(playerNames.size());
        final LadderOutputDto ladderOutputDto = ladderGame.play(new LadderInputDto(playerNames, height, goals));

        screen.printLadder(playerNames, ladderOutputDto.getLadderShape(), goals);
        printResult(ladderOutputDto.getLadderResult());
    }

    private void printResult(LadderResult ladderResult) {
        String selectResult;

        while (!EXIT_INPUT.equals(selectResult = screen.inputSelectResult())) {
            screen.printResult(ladderResult, selectResult);
        }

        System.out.println("게임을 종료합니다.");
    }

    private List<String> readGoals(int playerNumber) {
        List<String> goals = Collections.emptyList();
        while (goals.isEmpty()) {
            goals = screen.inputGoals();
        }

        checkMatchNumberOf(playerNumber, goals);

        return goals;
    }

    private void checkMatchNumberOf(int playerNumber, List<String> goals) {
        if (playerNumber != goals.size()) {
            System.out.println("플레이어 수만큼 결과를 입력하세요.");
            readGoals(playerNumber);
        }
    }

    private int readLadderHeight() {
        return screen.inputLadderHeight().orElseGet(this::readLadderHeight);
    }

    private List<String> readPlayerNames() {
        List<String> playerNames = Collections.emptyList();

        while (playerNames.isEmpty()) {
            playerNames = screen.inputPlayerNames();
        }

        return playerNames;
    }
}
