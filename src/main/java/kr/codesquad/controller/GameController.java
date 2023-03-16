package kr.codesquad.controller;

import kr.codesquad.domain.destination.DestinationGroup;
import kr.codesquad.domain.ladder.Ladder;
import kr.codesquad.domain.player.PlayerGroup;
import kr.codesquad.domain.result.ResultGroup;
import kr.codesquad.exception.GameProgressException;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class GameController {
    private InputView inputView = new InputView(System.in);
    private OutputView outputView = new OutputView();

    public void runLadderGame() {
        while(true) {
            try {
                executeLadderGameCycle();
            } catch (GameProgressException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                System.out.println();
            }
        }
    }

    private void executeLadderGameCycle() throws IOException, GameProgressException {
        System.out.println("-----[사다리 게임 시작]-----");
        PlayerGroup playerGroup = createPlayerGroup();
        DestinationGroup destinationGroup = createDestinationGroup(playerGroup.getPlayerCount());
        Ladder ladder = createLadder(playerGroup.getPlayerCount());
        ResultGroup resultGroup = new ResultGroup(playerGroup, destinationGroup, ladder);

        outputView.printPlayerNames(playerGroup);
        outputView.printLadder(ladder);
        outputView.printDestination(destinationGroup);
        runPrintResultLoop(resultGroup);
    }

    private PlayerGroup createPlayerGroup() throws IOException {
        while(true) {
            try {
                return new PlayerGroup(inputView.inputPlayerNames());
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage() + System.lineSeparator());
            }
        }
    }

    private DestinationGroup createDestinationGroup(int playerCount) throws IOException {
        while(true) {
            try {
                return new DestinationGroup(inputView.inputDestinationNames(), playerCount);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage() + System.lineSeparator());
            }
        }
    }

    private Ladder createLadder(int playerCount) throws IOException {
        while(true) {
            try {
                return new Ladder(playerCount, inputView.inputLadderHeight());
            } catch (NumberFormatException e) {
                System.out.println("최대 사다리 높이는 정수만 입력해 주세요.");
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage() + System.lineSeparator());
            }
        }
    }

    private void runPrintResultLoop(ResultGroup resultGroup) throws IOException, GameProgressException {
        while(true) {
            try {
                outputView.printResult(resultGroup, inputView.inputSelectPlayer());
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage() + System.lineSeparator());
            }
        }
    }

}
