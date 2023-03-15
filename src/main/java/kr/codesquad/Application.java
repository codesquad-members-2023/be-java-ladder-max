package kr.codesquad;

import kr.codesquad.controller.LadderGame;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        LadderGame controller = new LadderGame();
        controller.run();
    }
}