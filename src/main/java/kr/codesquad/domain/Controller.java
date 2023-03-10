package kr.codesquad.domain;

import kr.codesquad.view.Input;

import java.io.IOException;

public class Controller {

    public void run() {
        Input input = new Input();

        try {
            String nameData = input.inputName();
            int height = input.inputHeight();
            input.closeBr();

            Ladder ladder = new Ladder(nameData, height);
            ladder.printRadder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
