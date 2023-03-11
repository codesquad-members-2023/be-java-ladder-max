package kr.codesquad.step3.domain;


import java.util.ArrayList;
import java.util.List;


public class Ladder {
    private final List<Line> ladder;
    private final int height;

    public Ladder(Participates participates, int inputHeight) {
        this.height = inputHeight;
        ladder = new ArrayList<>();
    }

}
