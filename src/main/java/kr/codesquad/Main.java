package kr.codesquad;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Ladder ladder = new Ladder();

        try {
            int[] input_data = input.input();

            ladder.createLine(input_data[0], input_data[1]);

            ladder.print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}