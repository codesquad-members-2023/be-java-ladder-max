package kr.codesquad.domain;

import java.util.List;
import java.util.Map;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderGame {

    private final InputView inputView;
    private final LadderDrawer ladderDrawer;
    private final OutputView outputView;
    private final LineStateRandomCreator linesStateRandomCreator;
    private final LadderResultCalculator ladderResultCalculator;
    private final LadderResultRepository ladderResultRepository;

    public LadderGame() {
        this.inputView = new InputView();
        this.ladderDrawer = new LadderDrawer();
        this.outputView = new OutputView();
        this.linesStateRandomCreator = new LineStateRandomCreator();
        this.ladderResultCalculator = new LadderResultCalculator();
        this.ladderResultRepository = new LadderResultRepository();
    }

    public void run() {
        List<String> names = inputView.inputNames();
        int nameSize = names.size();
        List<String> resultInfo = inputView.inputResultInfo(nameSize);
        int ladderHeight = inputView.inputLadderHeight();
        List<List<Boolean>> linesStateInfo = linesStateRandomCreator.create(nameSize, ladderHeight);
        String drawnLadder = drawLadder(linesStateInfo);
        printLadder(names, drawnLadder, resultInfo);
        ladderResultCalculator.calculator(linesStateInfo,ladderResultRepository);

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
                Map<Integer, Integer> usersOfResult = ladderResultRepository.getAll();
                outputView.printAll(names, result, usersOfResult);
                break;
            }
            case SINGLE: {
                int index = names.indexOf(searchInfo.getName());
                outputView.printSingleResult(result, ladderResultRepository.get(index));
                break;
            }
        }
        inputSearchInfo(names, result);
    }

    private void printLadder(List<String> names, String drawnLadder, List<String> result) {
        outputView.printLadder(names, drawnLadder, result);
    }

    private String drawLadder(List<List<Boolean>> linesStateInfo) {
        return ladderDrawer.draw(linesStateInfo);
    }
}
