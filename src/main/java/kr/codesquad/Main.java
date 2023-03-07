package kr.codesquad;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LadderController controller;
        controller = new LadderController(outputView, inputView);
        controller.startLadderGame();
    }
}
