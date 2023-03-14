package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderGenerator;
import kr.codesquad.domain.Users;
import kr.codesquad.util.Validation;

import java.io.IOException;

public class GameController {
    private final Users users;
    private final int ladderHeight;
    public GameController(String names, String ladderNumber) throws IOException {
        Validation validation = new Validation();
        users = validation.validateInputNames(names);
        ladderHeight = validation.validateInputLadderNumber(ladderNumber);
    }

    public String start() {
        LadderGenerator ladderGenerator = new LadderGenerator();
        Ladder ladder = ladderGenerator.make(users, ladderHeight);
        ladder.play();
        return show(users, ladder);
    }

    private String show(Users users, Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        sb.append(users.show());
        sb.append(ladder.show());
        return sb.toString();
    }
}
