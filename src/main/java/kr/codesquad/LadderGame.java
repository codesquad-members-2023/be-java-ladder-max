package kr.codesquad;

public class LadderGame {
    private final ConsoleInput consoleInput;

    public LadderGame(ConsoleInput consoleInput) {
        this.consoleInput = consoleInput;
    }

    public void start(){
        int minPerson = consoleInput.inputPerson();
        int maximumLadderHeight = consoleInput.inputMaximumLadderHeight();
        Ladder ladder = new Ladder(minPerson, maximumLadderHeight);
        String[][] board = ladder.generate();
        LadderConverter converter = new LadderConverter(board);
        String ladderStr = converter.convertToString();
        ConsoleOutput.printLadderBoard(ladderStr);
    }
}
