package kr.codesquad.controller;

import kr.codesquad.domain.destination.DestinationGroup;
import kr.codesquad.domain.ladder.Ladder;
import kr.codesquad.domain.player.PlayerGroup;
import kr.codesquad.domain.result.ResultGroup;
import kr.codesquad.exception.GameProgressException;
import kr.codesquad.view.InputView;

import java.io.IOException;
import java.io.InputStream;

public class GUIGameController {
    private InputView inputView;
    private PlayerGroup playerGroup;
    private DestinationGroup destinationGroup;
    private Ladder ladder;
    private ResultGroup resultGroup;

    public GUIGameController(InputStream is) throws IOException {
        this.inputView = new InputView(is);
        initializeGame();
    }

    private void initializeGame() throws IOException {
        playerGroup = new PlayerGroup(inputView.inputPlayerNames());
        destinationGroup = new DestinationGroup(inputView.inputDestinationNames(), playerGroup.getPlayerCount());
        ladder = new Ladder(playerGroup.getPlayerCount(), inputView.inputLadderHeight());
        resultGroup = new ResultGroup(playerGroup, destinationGroup, ladder);
    }

    public String renderLadder() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator())
                .append(playerGroup).append(System.lineSeparator())
                .append(ladder)
                .append(destinationGroup).append(System.lineSeparator());
        System.out.println(sb);
        return sb.toString();
    }

    public String renderResults() throws GameProgressException {
        return resultGroup.getResult("all");
    }


}
