package kr.codesquad.ladder.domain;

import java.util.Random;
import kr.codesquad.ladder.view.LadderReader;
import kr.codesquad.ladder.view.LadderWriter;

public class LadderGame {

    private final LadderReader ladderConsoleReader;
    private final LadderWriter ladderWriter;

    public LadderGame(LadderReader ladderConsoleReader, LadderWriter ladderWriter) {
        this.ladderConsoleReader = ladderConsoleReader;
        this.ladderWriter = ladderWriter;
    }

    public void start() {
        Random random = new Random();
        Names names = ladderConsoleReader.readNameOfPeople();
        LadderGenerator ladderGenerator = ladderConsoleReader.readMaximumLadderHeight();
        Ladder ladder = ladderGenerator.createLines(names.size(), random);
        ladderWriter.write(names);
        ladderWriter.write(ladder);
    }
}
