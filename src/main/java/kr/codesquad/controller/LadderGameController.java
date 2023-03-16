package kr.codesquad.controller;

import kr.codesquad.controller.dto.LadderInputDto;
import kr.codesquad.controller.dto.LadderOutputDto;
import kr.codesquad.domain.LadderResult;
import kr.codesquad.service.LadderGame;
import kr.codesquad.view.Screen;

import java.util.List;
import java.util.Optional;

public class LadderGameController {
    private static final String EXIT_INPUT = "춘식이";

    private final LadderGame ladderGame;
    private final Screen screen;

    public LadderGameController(LadderGame ladderGame, Screen screen) {
        this.ladderGame = ladderGame;
        this.screen = screen;
    }

    public void run() {
        final List<String> playerNames = inputPlayerNames();
        final int height = inputLadderHeight();
        final List<String> goals = inputGoals(playerNames.size());
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

    private List<String> inputGoals(int playerNumber) {
        Optional<List<String>> goals = Optional.empty();
        while (goals.isEmpty()) {
            goals = screen.inputGoals();
        }
        if (isNotMatchOfPlayerNumber(playerNumber, goals.get())) {
            System.out.println("플레이어 수만큼 결과를 입력하세요.");
            return inputGoals(playerNumber);
        }

        return goals.get();
    }

    private boolean isNotMatchOfPlayerNumber(int playerNumber, List<String> goals) {
        return goals.size() != playerNumber;
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
