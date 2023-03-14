package kr.codesquad;

import kr.codesquad.domain.Ladder;
import kr.codesquad.view.InputInformation;
import kr.codesquad.view.OutputLadder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final InputInformation inputInformation;
    private final OutputLadder outputLadder;

    public LadderGame(InputInformation inputInformation, OutputLadder outputLadder) {
        this.inputInformation = inputInformation;
        this.outputLadder = outputLadder;
    }

    public void run() throws IOException {
        List<String> playerList = inputInformation.putPlayerNames();
        int numberOfPlayer = playerList.size();
        int maximumHeight = inputInformation.putMaxHeight();
        Ladder ladder = new Ladder(numberOfPlayer, maximumHeight);
        String[][] finishedLadder = ladder.generateLadder();
        outputLadder.printPlayerNames(playerList);
        outputLadder.printLadder(finishedLadder);
    }

}
