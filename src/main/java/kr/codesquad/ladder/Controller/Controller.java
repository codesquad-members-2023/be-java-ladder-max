package kr.codesquad.ladder.Controller;

import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.User;
import kr.codesquad.ladder.view.Input;
import kr.codesquad.ladder.view.Output;
import kr.codesquad.ladder.view.Validator;

import java.io.IOException;

public class Controller {
    public void run() throws IOException {
        String userName = Input.insertUser();
        User user = new User(userName);
        Validator validator = new Validator();
        while (!validator.nameValidate(userName.split(","))){
            userName = Input.insertUser();
            user = new User(userName);
        }
        int userCount = userName.split(",").length;
        Ladder ladder = new Ladder(Input.ladderLength(),userCount);
        Output.printAll(user.toString(),ladder.toString());
    }

}
