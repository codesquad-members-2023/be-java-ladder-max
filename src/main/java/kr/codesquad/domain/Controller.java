package kr.codesquad.domain;

import kr.codesquad.view.Input;

import java.io.IOException;

public class Controller {

    public void run() {
        Input input = new Input();
        try {
            Ladder ladder = new Ladder(input.inputName(), input.inputHeight());
            ladder.printRadder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
