package kr.codesquad.ladder.Controller;

import kr.codesquad.ladder.domain.*;
import kr.codesquad.ladder.view.Input;
import kr.codesquad.ladder.view.Output;
import kr.codesquad.ladder.view.Validator;

import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

public class Controller {


    public void run() throws IOException {
            Input input = new Input();
            String userName = input.vaildName();
            int userCount = userName.split(",").length;
            String resultName = input.vaildResult(userCount);
            User user = new User(userName);
            Result result = new Result(resultName);
            Ladder ladder = new Ladder(input.ladderLength(), userCount);
            ResultLog resultLog = new ResultLog(ladder,user,result,userCount);
            Output.printAll(user.toString(),ladder.toString(),result.toString());
            searchLoop(resultLog,input);
    }
    private void searchLoop(ResultLog resultLog,Input input) throws IOException {
            boolean sw = true;
            while (sw) {
                    String name = resultLog.existValidate(input.insertFindUser(),input);
                    sw = end(name);
                    Output.resultAll(name);
            }
    }
    private boolean end(String name){
            if(name.equals("춘식이 입력 게임종료")) {
                    return false;
            }
            return true;
    }


}
