package kr.codesquad.contoroller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.view.InputView;
import kr.codesquad.domain.Line;
import kr.codesquad.view.OutputView;
import kr.codesquad.domain.Players;

public class LadderGameController {
    InputView inputView;
    OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printInputPlayers();
        String inputPlayers = inputView.userInput();
        outputView.printInputHeight();
        int height = Integer.parseInt(inputView.userInput());

        Players players = new Players(inputPlayers);
        Line line = new Line(height);
        line.generateLine(height);

        Ladder ladder = new Ladder(players.getSize(), height);
        outputView.printLadderResult(ladder, players);
    }
}