package mission.controller;

import mission.model.Ladder;
import mission.view.InputView;
import mission.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        InputView inputView = new InputView();
        String[] peopleNames = inputView.getPeopleName();
        int ladderHeight = inputView.getLadderHeight();

        Ladder ladder = new Ladder();
        ladder.makeLadder(peopleNames.length, ladderHeight);

        OutputView outputView = new OutputView();
        outputView.printPeopleNameAndLadder(peopleNames,ladderHeight, ladder.getLadder());
    }
}
