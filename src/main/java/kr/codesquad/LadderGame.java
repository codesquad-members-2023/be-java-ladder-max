package kr.codesquad;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Player;
import kr.codesquad.view.InputInformation;
import kr.codesquad.view.OutputInformation;

import java.io.IOException;
import java.util.List;

public class LadderGame {
    private final InputInformation inputInformation;
    private final OutputInformation outputInformation;

    public LadderGame(InputInformation inputInformation, OutputInformation outputInformation) {
        this.inputInformation = inputInformation;
        this.outputInformation = outputInformation;
    }

    public void run() throws IOException {
        List<String> playerList = inputInformation.putPlayerNames();
        int numOfPlayer = playerList.size();
        int columnLength = inputInformation.putMaxHeight();
        Ladder ladder = new Ladder();
        String finishedLadder = ladder.format(ladder.generateLadder(numOfPlayer, columnLength));
        Player player = new Player();
        String playerNameLabel = player.nameLabelFormat(playerList);
        outputInformation.printPlayerNames(playerNameLabel);
        outputInformation.printLadder(finishedLadder);
    }

}
