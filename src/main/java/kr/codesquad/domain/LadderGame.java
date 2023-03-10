package kr.codesquad.domain;

import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.List;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderResultRepository ladderResultRepository;

    public LadderGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.ladderResultRepository = new LadderResultRepository();
    }

    public void run() {

        List<String> names = inputView.inputNames();
        int nameSize = names.size();

        List<String> resultInfo = inputView.inputResultInfo(nameSize);
        int ladderHeight = inputView.inputLadderHeight();

        LinesInfo linesInfo = LinesInfo.create(nameSize, ladderHeight);
        String drawnLadder = drawLadder(linesInfo);
        printLadder(names, drawnLadder, resultInfo);

        ladderResultRepository.saveNamesAndResultINFO(names, resultInfo);
        linesInfo.calculator(ladderResultRepository);

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
                outputView.printResult(searchAll);
                break;
            }
            case SINGLE: {
                String singleResult = ladderResultRepository.searchSingleResult(searchInfo.getName());
                outputView.printResult(singleResult);
                break;
            }
        }
        inputSearchInfo();
    }

    private void printLadder(List<String> names, String drawnLadder, List<String> result) {
        outputView.printLadder(names, drawnLadder, result);
    }

    private String drawLadder(LinesInfo linesInfo) {
        return linesInfo.draw();
    }
}
