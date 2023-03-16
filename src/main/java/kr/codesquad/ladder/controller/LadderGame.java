package kr.codesquad.ladder.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kr.codesquad.ladder.domain.Destinations;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.LadderGenerator;
import kr.codesquad.ladder.domain.Name;
import kr.codesquad.ladder.domain.Names;
import kr.codesquad.ladder.view.LadderReader;
import kr.codesquad.ladder.view.LadderWriter;

public class LadderGame {

    private final LadderConsoleReaderController readerController;
    private final LadderWriter ladderWriter;

    public LadderGame(LadderConsoleReaderController readerController, LadderWriter ladderWriter) {
        this.readerController = readerController;
        this.ladderWriter = ladderWriter;
    }

    public void start() {
        Random random = new Random();
        Names namesOfPeoples = readerController.getNamesOfPeoples();
        Destinations destinations = readerController.getDestinations(namesOfPeoples.size());
        LadderGenerator ladderGenerator = readerController.getLadderGenerator();
        Ladder ladder = ladderGenerator.createLines(namesOfPeoples.size(), random);
        ladderWriter.write(namesOfPeoples.toString());
        ladderWriter.write(ladder.toString());
        ladderWriter.write(destinations.toString());
        readerController.startReadNameOfPeopleForLadderResult(namesOfPeoples, ladder, destinations);
    }
}
