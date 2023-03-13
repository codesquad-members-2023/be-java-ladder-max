package kr.ladder.domain;


import kr.ladder.view.InputView;
import kr.ladder.view.OutputView;

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
                ladder.makeLadder(peopleNames.length, inputView.getLadderHeight());
                outputView.printPeopleNameAndLadder(peopleNames, ladder.getLadder());
        }
}
