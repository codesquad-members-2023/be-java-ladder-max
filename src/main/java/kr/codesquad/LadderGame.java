package kr.codesquad;

public class LadderGame {

    private final ConsoleInput consoleInput;

    public LadderGame(ConsoleInput consoleInput) {
        this.consoleInput = consoleInput;
    }

    public void start() {
        int numberOfPeople = consoleInput.readNumberOfPeople();
        int maximumLadderHeight = consoleInput.readMaximumLadderHeight();
        Ladder ladder = new Ladder(numberOfPeople, maximumLadderHeight);
        String[][] board = ladder.generate();
        LadderConverter converter = new LadderConverter(board);
        String ladderStr = converter.convertToString();
        ConsoleOutput.printLadderBoard(ladderStr);
    }
}
