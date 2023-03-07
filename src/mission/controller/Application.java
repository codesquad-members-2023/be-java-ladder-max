package mission.controller;

import mission.model.Ladder;
import mission.view.InputView;
import mission.view.OutputView;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        InputView inputView = new InputView();
        Ladder ladder = new Ladder();
        ladder.makeLadder(inputView.getPeopleNumber(), inputView.getLadderHeight());

        OutputView outputView = new OutputView();
        outputView.printStrings(ladder.getLadder());
    }
}
