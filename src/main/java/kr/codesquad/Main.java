package kr.codesquad;

import kr.codesquad.controller.GameController;
import kr.codesquad.domain.Ladder;
import kr.codesquad.view.OutputView;
import kr.codesquad.view.InputView;

import java.io.IOException;

public class Main {

    private static GameController controller = new GameController();

    private static void runApplication() {
        try {
            controller.runLadderGame();
        } catch (NumberFormatException e) {
            System.out.println("잘못된 값을 입력하였습니다. 다시 입력해 주세요.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        while (true) {
            runApplication();
        }

    }
}
