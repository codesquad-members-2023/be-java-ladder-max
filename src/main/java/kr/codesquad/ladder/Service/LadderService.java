package kr.codesquad.ladder.Service;

import kr.codesquad.ladder.domain.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class LadderService {
    User user;
    Result result;
    Ladder ladder;
    ResultLog resultLog;


    public String makeLadder(int length, String name, String resultName) {
        int countOfPesron = name.split(",").length;
         user = new User(name);
         result = new Result(resultName);
         ladder = new Ladder(length,countOfPesron);
         resultLog = new ResultLog(ladder,user,result,countOfPesron);
        return ladder.toString();
    }

    public String resultLadder(String search)  {
        return resultLog.existValidate(search);
    }

}
