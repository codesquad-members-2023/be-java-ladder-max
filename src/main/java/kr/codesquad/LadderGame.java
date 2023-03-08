package kr.codesquad;

import java.util.Random;

public class LadderGame {

    private final ConsoleInput consoleInput;

    public LadderGame(ConsoleInput consoleInput) {
        this.consoleInput = consoleInput;
    }

    public void start() {
        int numberOfPeople = consoleInput.readNumberOfPeople();
        int maximumLadderHeight = consoleInput.readMaximumLadderHeight();
        Ladder ladder = new Ladder(numberOfPeople, maximumLadderHeight);
        Random random = new Random();
        LadderPartGenerator generator = new LadderPartGenerator(random);
        String[][] board = generator.generate(ladder);
        LadderConverter converter = new LadderConverter(board);
        String ladderStr = converter.convertToString();
        ConsoleOutput.printLadderBoard(ladderStr);
    }
}
