package kr.codesquad;

import java.util.ArrayList;
import java.util.Objects;

public class LadderGame {
    private final Output output = new Output();
    private final Input input = new Input();


    public void start() {
        ArrayList<Object> userInput = getLadderInput();

        Ladder ladder = new Ladder();

        ladder.makeLadderShape(userInput);

        output.printLadder(ladder.getLadder());
    }

    private ArrayList<Object> getLadderInput() {
        ArrayList<Object> userInput = new ArrayList<>();

        output.printNameOfPeople();
        String peopleName = input.getInput();
        userInput.add(peopleName);

        output.printHeightOfLadder();
        int height = Integer.parseInt(input.getInput());
        userInput.add(height);

        return userInput;
    }

}
