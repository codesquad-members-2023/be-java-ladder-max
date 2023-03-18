package kr.codesquad.ladder.Service;

import kr.codesquad.ladder.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LadderService {

    public String makeLadder(int length, String name, String resultName) {
        int countOfPesron = name.split(",").length;
        User user = new User(name);
        Result result = new Result(resultName);
        Ladder ladder = new Ladder(length,countOfPesron);
        ResultLog resultLog = new ResultLog(ladder,user,result,countOfPesron);
        return ladder.toString();
    }

}
