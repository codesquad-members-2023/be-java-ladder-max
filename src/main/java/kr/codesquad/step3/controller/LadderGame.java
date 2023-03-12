package kr.codesquad.step3.controller;


import kr.codesquad.step3.domain.Ladder;
import kr.codesquad.step3.domain.Participates;
import kr.codesquad.step3.view.InputView;
import kr.codesquad.step3.view.OutputView;

public class LadderGame {
    public void run(){
        String participateNames = InputView.inputParticipateNames();
        Participates participates =Participates.createParticipates(participateNames);
        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(participates,height);

        OutputView.showParticipates(participates);
        OutputView.showLadder(ladder);
    }
}
