package kr.codesquad.Controller;

import kr.codesquad.Domain.Ladder;
import kr.codesquad.Domain.User;
import kr.codesquad.View.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    private Ladder ladder;
    public LadderController(){
        ladder = new Ladder(convertInputToListUser(InputView.getLadderWidth()));
    }
    public List<User> convertInputToListUser(String user){
        return Arrays.stream(user.split(",")).map(User::new).collect(Collectors.toList());
    }
    public void run(){
        ladder.printLadderInfo();
    }
}
