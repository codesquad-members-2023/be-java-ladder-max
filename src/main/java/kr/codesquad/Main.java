package kr.codesquad;

import kr.codesquad.controller.LadderGameController;

public class Main {
    public static void main(String[] args) {
        final LadderGameController ladderGameController = new LadderGameController();
        ladderGameController.run();
    }
}