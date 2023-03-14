package kr.codesquad.controller;

import kr.codesquad.domain.LadderGenerator;
import kr.codesquad.domain.Players;
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
//        String[] names = inputView.inputNames().split(",");
//        Players players = new Players(names);

        outputView.printMaxHeightPrompt();
        int ladderHeight = inputView.inputLadderHeight();

        this.ladderGenerator = new LadderGenerator(ladderHeight, ladderHeight); // 다른 방법 찾아보기
        String[][] ladder = ladderGenerator.generateLadder();
        outputView.printLadder(ladder);
    }


}