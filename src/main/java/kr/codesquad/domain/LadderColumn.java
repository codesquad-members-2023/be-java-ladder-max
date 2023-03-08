package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.util.List;

public class LadderColumn {
    private final InputView inputView = new InputView();

    LadderColumn(){
        inputView.inputPeopleName();
    }

    public void makeLadderColumn(){
        List<String> names = inputView.inputPeopleName();
        int ladderColumnSize = names.size();


    }
}
