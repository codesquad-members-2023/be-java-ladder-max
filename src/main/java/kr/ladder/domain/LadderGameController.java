package kr.ladder.domain;


import kr.ladder.view.InputView;
import kr.ladder.view.OutputView;

import java.io.IOException;

public class LadderGameController {
        private final InputView inputView;

        private final Ladder ladder;

        private final OutputView outputView;
        private final InputValidation validation;

        public LadderGameController() {
                this.inputView = new InputView();
                this.ladder = new Ladder();
                this.outputView = new OutputView();
                this.validation = new InputValidation();
        }

        public void run() throws IOException {
                // 입력
                String[] players = validation.inspectPlayers(inputView.getPlayer());
                int ladderHeight = validation.inspectLadderHeight(inputView.getLadderHeight());
                // 사다리 만들기
                ladder.make(players.length, ladderHeight);
                // 출력
                outputView.printPlayersAndLadder(players, ladder.toString());
        }
}
