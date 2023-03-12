package kr.codesquad.ladder.Controller;

import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.User;
import kr.codesquad.ladder.view.Input;
import kr.codesquad.ladder.view.Output;

import java.io.IOException;

public class Controller {
    public void run() throws IOException {
        Input input = new Input();
        String userName = input.insertUser();
        int userCount = userName.split(",").length;
        User user = new User(userName);
        Ladder ladder = new Ladder(Input.ladderLength(),userCount);
        Output.printAll(user.toString(),ladder.toString());

    }

}
