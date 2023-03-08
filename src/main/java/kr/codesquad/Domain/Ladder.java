package kr.codesquad.Domain;

import kr.codesquad.Util.LadderMaker;
import kr.codesquad.View.InputView;
import kr.codesquad.View.OutputView;

import java.util.List;

public class Ladder {
    private List<Line> ladder;
    private LadderMaker ladderMaker;
    private List<User> users;

    public List<Line> getLadder() {
        return ladderMaker.makeLadder(users.size(), InputView.getLadderHeight());
    }


    public Ladder(List<User> users) {
        ladderMaker = new LadderMaker();
        this.users = users;
        this.ladder = getLadder();

    }
    public void printLadderInfo(){
        OutputView.printUsers(this.users);
        OutputView.printLadder(this.ladder);
    }
}
