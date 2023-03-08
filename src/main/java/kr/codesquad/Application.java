package kr.codesquad;

import kr.codesquad.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> nameList = inputView.inputPeopleName();
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println(nameList.get(i));
        }
//        Ladder ladder = new Ladder(InputView.inputPeopleName(), InputView.inputLadderHeight());
//        Outputview.printLadder(ladder.makeLadder());
        inputView.close();
    }
}

