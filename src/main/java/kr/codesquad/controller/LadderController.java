package kr.codesquad.controller;

import kr.codesquad.model.Ladder;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.List;

public class LadderController {
    private final InputView inputView;

    public LadderController() {
        inputView = new InputView();
    }

    public void run() {
        List<String> people = inputView.getPeople();
        int maxHeight = inputView.getMaxHeight();
        Ladder ladder = new Ladder(people.size(), maxHeight);
        ladder.generateLegs();
        OutputView.printPeople(people);
        OutputView.printLadder(ladder);
    }
}
