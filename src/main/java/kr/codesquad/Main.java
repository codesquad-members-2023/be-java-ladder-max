package kr.codesquad;

import kr.codesquad.domain.Ladder;
import kr.codesquad.view.OutputView;
import kr.codesquad.view.InputView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Ladder ladder = new Ladder();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        while (true) {
            try {
                int playerCount = inputView.inputPlayerCount();
                int ladderHeight = inputView.inputLadderHeight();
                String[][] newLadder = ladder.makeLadder(playerCount, ladderHeight);
                outputView.printLadder(newLadder);
            } catch (NumberFormatException e) {
                System.out.println("잘못된 값을 입력하였습니다. 다시 입력해 주세요.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}