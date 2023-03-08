package kr.codesquad.domain;

import java.util.List;
import java.util.Map;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderGame {

    private final InputView inputView = new InputView();
    private final LadderByNames ladder = new LadderByNames();
    private final OutputView outputView = new OutputView();

    public void run() {
        List<String> names = inputView.inputNames();
        int nameSize = names.size();
        List<String> resultInfo = inputView.inputResultInfo(nameSize);
        int ladderHeight = inputView.inputLadderHeight();
        String drawnLadder = drawLadder(nameSize, ladderHeight);
        printLadder(names, drawnLadder, resultInfo);
        inputSearchInfo(names, resultInfo);
    }

    private void inputSearchInfo(List<String> names, List<String> result) {
        SearchInfo searchInfo = inputView.inputSearchInfo(names);
        SearchType searchType = searchInfo.getSearchType();
        switch (searchType) {
            case CLOSE:
                outputView.printClose();
                return;
            case ALL: {
                Map<Integer, Integer> usersOfResult = ladder.getUsersOfResult();
                outputView.printAll(names, result, usersOfResult);
                break;
            }
            case SINGLE: {
                Map<Integer, Integer> usersOfResult = ladder.getUsersOfResult();
                int index = names.indexOf(searchInfo.getName());
                outputView.printSingle(result, usersOfResult.get(index));
                break;
            }
        }
        inputSearchInfo(names, result);
    }

    private void printLadder(List<String> names, String drawnLadder, List<String> result) {
        outputView.print(names, drawnLadder, result);
    }

    private String drawLadder(Integer peopleCount, Integer ladderHeight) {
        return ladder.draw(peopleCount, ladderHeight);
    }
}
