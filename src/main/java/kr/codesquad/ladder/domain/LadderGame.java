package kr.codesquad.ladder.domain;

import java.util.Random;
import kr.codesquad.ladder.view.LadderReader;
import kr.codesquad.ladder.view.LadderWriter;

public class LadderGame {

    private final LadderReader ladderReader;
    private final LadderWriter ladderWriter;

    public LadderGame(LadderReader ladderReader, LadderWriter ladderWriter) {
        this.ladderReader = ladderReader;
        this.ladderWriter = ladderWriter;
    }

    public void start() {
        Random random = new Random();
        Names names = ladderReader.readNameOfPeople();
        LadderResults ladderResults = ladderReader.readLadderResults(names.size());
        LadderGenerator ladderGenerator = ladderReader.readMaximumLadderHeight();
        Ladder ladder = ladderGenerator.createLines(names.size(), random);
        ladderWriter.write(names.toString());
        ladderWriter.write(ladder.toString());
        ladderWriter.write(ladderResults.toString());
    }
}
