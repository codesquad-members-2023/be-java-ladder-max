package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.util.Encoding;
import kr.codesquad.util.Validation;

import java.io.IOException;
import java.util.List;

public class GameController {
    public GameController(String names, String ladderNumber) throws IOException {
        Validation validation = new Validation();
        validation.validateInputNames(names);
        validation.validateInputLadderNumber(ladderNumber);
    }

    public String showShape(Ladder ladder) {
        Encoding encoding = new Encoding();
        return encoding.encodeLadder(ladder);
    }

    public void makeLadder() {
        List<List<String>>
    }
}
