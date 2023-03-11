package kr.codesquad.step3.domain;


import java.util.ArrayList;
import java.util.List;

import kr.codesquad.step3.util.Validation;

public class Ladder {
    private final List<Line> ladder;
    private final int height;

    public Ladder(Participates participates, int inputHeight) {
        this.height = checkHeight(inputHeight);
        ladder = new ArrayList<>();
    }

    private int checkHeight(int inputHeight) {
        Validation.validateIsMinHeight(inputHeight);
        return inputHeight;
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
