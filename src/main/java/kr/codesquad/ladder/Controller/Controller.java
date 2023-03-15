package kr.codesquad.ladder.Controller;

import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.Result;
import kr.codesquad.ladder.domain.ResultLog;
import kr.codesquad.ladder.domain.User;
import kr.codesquad.ladder.view.Input;
import kr.codesquad.ladder.view.Output;
import kr.codesquad.ladder.view.Validator;

import java.io.IOException;
import java.util.Collections;

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
            Result result = new Result(Input.insertResult());
            ResultLog resultLog = new ResultLog(ladder,user,result);
            Output.printAll(user.toString(),ladder.toString(),result.toString());

            System.out.println(resultLog.findResult(Input.insertUser()));
            System.out.println(resultLog);
        // System.out.println(ladder.getLadder());
    }

}
