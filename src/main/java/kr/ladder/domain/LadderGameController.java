package main.java.kr.ladder.domain;

import main.java.kr.ladder.view.InputView;
import main.java.kr.ladder.view.OutputView;

import java.io.IOException;

public class LadderGameController {
        private InputView inputView;

        private Ladder ladder;

        private OutputView outputView;

        public LadderGameController() {
                this.inputView = new InputView();
                this.ladder = new Ladder();
                this.outputView = new OutputView();
        }

        public void run() throws IOException {
                String[] peopleNames = inputView.getPeopleName();
                int ladderHeight = inputView.getLadderHeight();
                ladder.makeLadder(peopleNames.length, ladderHeight);
                outputView.printPeopleNameAndLadder(peopleNames,ladderHeight, ladder.getLadder());
        }
}
