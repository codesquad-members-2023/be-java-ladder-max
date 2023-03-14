package kr.codesquad.controller;

import kr.codesquad.domain.LadderGenerator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

// 사용자 입력 처리 및 model, view 관리
public class LadderGameController {
    private final OutputView outputView;
    private final InputView inputView;
    private LadderGenerator ladderGenerator;

    public LadderGameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void startLadderGame() {
        outputView.printPlayersPrompt();
        String joinMembers = inputView.userInput();
        outputView.printMaxHeightPrompt();
        int maxHeight = Integer.parseInt(inputView.userInput());

        this.ladderGenerator = new LadderGenerator(joinMembers, maxHeight); // 다른 방법 찾아보기
        String[][] ladder = ladderGenerator.generateLadder();
        outputView.printLadder(ladder);
    }


}