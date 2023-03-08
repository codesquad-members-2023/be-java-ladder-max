package kr.codesquad;

import java.util.Random;

public class LadderGame {

    private final LadderConsoleReader ladderConsoleReader;
    private final LadderWriter ladderWriter;

    public LadderGame(LadderConsoleReader ladderConsoleReader, LadderWriter ladderWriter) {
        this.ladderConsoleReader = ladderConsoleReader;
        this.ladderWriter = ladderWriter;
    }

    public void start() {
        int numberOfPeople = ladderConsoleReader.readNumberOfPeople();
        int maximumLadderHeight = ladderConsoleReader.readMaximumLadderHeight();
        Ladder ladder = new Ladder(numberOfPeople, maximumLadderHeight);
        Random random = new Random();
        LadderPartGenerator generator = new LadderPartGenerator(random);
        String[][] board = generator.generate(ladder);
        LadderConverter converter = new LadderConverter(board);
        String ladderStr = converter.convertToString();
        ladderWriter.writeLadder(ladderStr);
    }
}
