package kr.codesquad;

import kr.codesquad.controller.GameController;

public class Main {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.runLadderGame();
    }
}
