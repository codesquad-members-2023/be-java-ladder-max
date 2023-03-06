package kr.codesquad;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Ladder ladder = new Ladder();

        try {
            int[] input_data = input.input();
            ladder.createRadder(input_data[0], input_data[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ladder.printRadder();
    }
}