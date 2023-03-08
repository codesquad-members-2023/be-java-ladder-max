package kr.codesquad;

import kr.codesquad.controller.LadderGameController;

import java.io.IOException;

public class LadderGame {
    public static void main(String[] args) throws IOException {
        LadderGameController controller = new LadderGameController();
        controller.startLadderGame();
    }
}