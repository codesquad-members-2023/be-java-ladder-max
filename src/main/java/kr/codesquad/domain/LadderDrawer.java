package kr.codesquad.domain;

import java.util.List;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderDrawer {

    private final InputView inputView = new InputView();
    private final Ladder ladder = new LadderByNames();
    private final OutputView outputView = new OutputView();

    public void runWithNamesAndResult() {
        List<String> names = inputView.inputNames();
        List<String> result = inputView.inputResult(names.size());
        Integer ladderHeight = inputView.inputLadderHeight();
        String drawnLadder = drawLadder(names.size(), ladderHeight);
        print(names, drawnLadder, result);
    }

    private void print(List<String> names, String drawnLadder, List<String> result) {
        outputView.print(names, drawnLadder, result);
    }

    public void runWithNames() {
        List<String> names = inputView.inputNames();
        Integer ladderHeight = inputView.inputLadderHeight();
        String drawnLadder = drawLadder(names.size(), ladderHeight);
        print(names, drawnLadder);
    }

    private void print(List<String> requestNames, String drawnLadder) {
        outputView.print(requestNames, drawnLadder);
    }

    private void runWithPeopleCount() {
        Integer peopleCount = inputView.inputPeopleCount();
        Integer ladderHeight = inputView.inputLadderHeight();
        String drawnLadder = drawLadder(peopleCount, ladderHeight);
        print(drawnLadder);

    }

    private String drawLadder(Integer peopleCount, Integer ladderHeight) {
        return ladder.draw(peopleCount, ladderHeight);
    }

    private void print(String drawnLadder) {
        outputView.print(drawnLadder);
    }

}
