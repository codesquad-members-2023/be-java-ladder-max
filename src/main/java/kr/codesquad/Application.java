package kr.codesquad;

import kr.codesquad.domain.Ladder;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class Application {
    /*
    final 키워드를 사용해야할까?
    멤버변수에서 Final 키워드를 사용할 시,
    1.생성자에서 할당
    -> Main 클래스에서 실행 시, Application이라는 생성자에 넣어줘야하는데 이는 깔끔하지 않음.
    어떻게 해결할 수 있지?
    또한, final이 재할당 금지여도 다시 내용을 바꿀 수 있다는 것은 List와 같은 것에 한정인가? 학습이 필요
     */
    private final InputView inputView;
    private final Ladder ladder;
    private final OutputView outputview;
    Application(){
        this.inputView = new InputView();
        this.ladder = new Ladder();
        this.outputview = new OutputView();
    }


    public void run() {
        ladder.makeLadder(inputView.inputPeopleSize(), inputView.inputLadderHeight());
        OutputView outputview = new OutputView();
        outputview.printPeopleList(inputView.getInputPeopleList());
        outputview.printLadder(ladder.getLadder());
        inputView.close();


    }

}

