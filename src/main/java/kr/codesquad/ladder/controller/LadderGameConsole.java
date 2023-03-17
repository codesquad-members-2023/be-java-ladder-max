package kr.codesquad.ladder.controller;

import java.util.Random;
import kr.codesquad.ladder.domain.Destinations;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.LadderGenerator;
import kr.codesquad.ladder.domain.Names;

public class LadderGameConsole {

    private final LadderGameConsoleController ladderGameConsoleController;

    public LadderGameConsole(LadderGameConsoleController ladderGameConsoleController) {
        this.ladderGameConsoleController = ladderGameConsoleController;
    }

    public void start() {
        Random random = new Random();
        Names namesOfPeoples = ladderGameConsoleController.getNamesOfPeoples();
        Destinations destinations = ladderGameConsoleController.getDestinations(
            namesOfPeoples.size());
        LadderGenerator ladderGenerator = ladderGameConsoleController.getLadderGenerator();
        Ladder ladder = ladderGenerator.createLines(namesOfPeoples.size(), random);
        ladderGameConsoleController.writeLadderGameStatus(namesOfPeoples, ladder, destinations);
        ladderGameConsoleController.startReadNameOfPeopleForLadderResult(namesOfPeoples, ladder,
            destinations);
    }
}
