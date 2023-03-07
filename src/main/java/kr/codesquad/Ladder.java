package kr.codesquad;
import kr.codesquad.Output;
import kr.codesquad.Input;

import java.util.Arrays;

public class Ladder {
    private Output output = new Output();
    private Input input = new Input();

    public void start() {
        int[] userInput = getInput();
        System.out.println(Arrays.toString(userInput));
    }

    private int[] getInput() {
        output.printNumberOfPeople();
        int people = Integer.parseInt(input.getInput());

        output.printHeightOfLadder();
        int height = Integer.parseInt(input.getInput());

        int[] result = {people, height};

        return result;
    }
}
