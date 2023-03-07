package kr.codesquad;

import kr.codesquad.controller.LadderController;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LadderController controller = new LadderController(outputView, inputView);
        controller.startLadderGame();
    }
}
