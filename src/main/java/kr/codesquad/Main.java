package kr.codesquad;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Ladder ladder = new Ladder();

        try {
            String inputNameData = input.inputName();
            int height = input.inputHeight();

            ladder.createRadder(inputNameData, height);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ladder.printRadder();
    }
}