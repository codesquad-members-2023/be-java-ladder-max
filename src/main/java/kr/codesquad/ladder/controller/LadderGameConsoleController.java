package kr.codesquad.ladder.controller;

import java.util.Random;
import kr.codesquad.ladder.domain.Destinations;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.LadderGenerator;
import kr.codesquad.ladder.domain.Names;

public class LadderGameConsoleController {

    private final LadderGameManager ladderGameManager;

    public LadderGameConsoleController(LadderGameManager ladderGameManager) {
        this.ladderGameManager = ladderGameManager;
    }

    public void start() {
        Random random = new Random();
        Names namesOfPeoples = ladderGameManager.getNamesOfPeoples();
        Destinations destinations = ladderGameManager.getDestinations(
            namesOfPeoples.size());
        LadderGenerator ladderGenerator = ladderGameManager.getLadderGenerator();
        Ladder ladder = ladderGenerator.createLines(namesOfPeoples.size(), random);
        ladderGameManager.writeLadderGameStatus(namesOfPeoples, ladder, destinations);
        ladderGameManager.startReadNameOfPeopleForLadderResult(namesOfPeoples, ladder,
            destinations);
    }
}
