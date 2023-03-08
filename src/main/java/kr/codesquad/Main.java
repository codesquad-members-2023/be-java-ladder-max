package kr.codesquad;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();

        try {
            String nameData = input.inputName();
            int height = input.inputHeight();
            input.closeBr();

            Ladder ladder = new Ladder(nameData, height);
            ladder.createRadder();
            ladder.printRadder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
