package kr.codesquad.ladder;

import kr.codesquad.ladder.Controller.Controller;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        controller.run();
    }
}
