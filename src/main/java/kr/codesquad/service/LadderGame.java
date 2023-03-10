package kr.codesquad.service;

import java.util.List;
import java.util.Random;
import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderConverter;
import kr.codesquad.domain.LadderPartGenerator;
import kr.codesquad.view.LadderConsoleReader;
import kr.codesquad.view.LadderWriter;

public class LadderGame {

    private final LadderConsoleReader ladderConsoleReader;
    private final LadderWriter ladderWriter;

    public LadderGame(LadderConsoleReader ladderConsoleReader, LadderWriter ladderWriter) {
        this.ladderConsoleReader = ladderConsoleReader;
        this.ladderWriter = ladderWriter;
    }

    public void start() {
        List<String> namesOfPeople = ladderConsoleReader.readNameOfPeople();
        int maximumLadderHeight = ladderConsoleReader.readMaximumLadderHeight();
        Ladder ladder = new Ladder(namesOfPeople, maximumLadderHeight);
        Random random = new Random();
        LadderPartGenerator generator = new LadderPartGenerator(random);
        List<List<String>> partLines = generator.generateLadderPart(ladder);
        LadderConverter converter = new LadderConverter();
        String ladderStr = converter.convertToString(partLines);
        ladderWriter.writeNamesOfPeople(ladder);
        ladderWriter.writeLadder(ladderStr);
    }
}
