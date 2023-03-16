package kr.codesquad;

import kr.codesquad.contoroller.LadderGameController;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderGameController controller = new LadderGameController(new InputView(), new OutputView());
        controller.run();
    }
}