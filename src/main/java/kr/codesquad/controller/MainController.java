package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Type;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    private Ladder ladder;

    public MainController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        this.ladder = inputView.enterCommand();
        outputView.printLadder(this.ladder);
        seeResult();
    }

    public void seeResult() {
        while (true) {
            outputView.wantPerson();
            findResult(inputView.insertInput());
        }
    }

    public void findResult(String input) {
        Type type = Type.find(input);
        if(executeType(type, input)) {
            return;
        }
        outputView.insertError();
    }

    private boolean executeType(Type type, String input) {
        if(type != null) {
            type.execute(this.ladder.getFinals(), outputView);
            return true;
        }
        return findOne(input);
    }

    private boolean findOne(String input) {
        if (this.ladder.getPeople().contains(input)) {
            outputView.printResults();
            outputView.printOne(this.ladder.getFinals(), input);
            return true;
        }
        return false;
    }
}
