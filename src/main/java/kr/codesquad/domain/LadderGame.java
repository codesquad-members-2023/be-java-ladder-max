package kr.codesquad.domain;

import java.util.List;
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
        List<LineInfo> linesStateInfo = linesStateRandomCreator.create(nameSize, ladderHeight);
        String drawnLadder = drawLadder(linesStateInfo);
        printLadder(names, drawnLadder, resultInfo);
        ladderResultRepository.saveNamesAndResultINFO(names, resultInfo);
        ladderResultCalculator.calculator(linesStateInfo, ladderResultRepository);
        inputSearchInfo();
    }

    private void inputSearchInfo() {
        SearchInfo searchInfo = inputView.inputSearchInfo(ladderResultRepository);
        SearchType searchType = searchInfo.getSearchType();
        switch (searchType) {
            case CLOSE:
                outputView.printClose();
                return;
            case ALL: {
                String searchAll = ladderResultRepository.searchAll();
                outputView.printAll(searchAll);
                break;
            }
            case SINGLE: {
                String singleResult = ladderResultRepository.searchSingleResult(searchInfo.getName());
                outputView.printSingleResult(singleResult);
                break;
            }
        }
        inputSearchInfo();
    }

    private void printLadder(List<String> names, String drawnLadder, List<String> result) {
        outputView.printLadder(names, drawnLadder, result);
    }

    private String drawLadder(List<LineInfo> linesStateInfo) {
        return ladderDrawer.draw(linesStateInfo);
    }
}
