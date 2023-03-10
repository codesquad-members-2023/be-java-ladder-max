package kr.codesquad.ladder.Controller;

import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.User;
import kr.codesquad.ladder.view.Input;
import kr.codesquad.ladder.view.Output;

import java.io.IOException;

public class Controller {
    public void run() throws IOException {
        Input input = new Input();
        User user = new User(input.insertUser());
        Ladder ladder = new Ladder(Input.ladderLength(),user.userList().size());
        Output.printAll(user,ladder.makeLadder());

    }

}
