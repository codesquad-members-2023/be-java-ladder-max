package kr.codesquad.domain;

import kr.codesquad.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladders;
    private final int height, people;

    public Ladder(int people, int height) {
        this.people = people;
        this.height = height;
        this.ladders = new ArrayList<>(); // 출력할 때 | 추가할거임
        makeLadder();
    }

    private void makeLadder() {
        for(int idx = 0; idx < height; idx++) {
            ladders.add(makeLine());
        }
    }

    private Line makeLine() {
        Line line = new Line();
        for(int idx = 0; idx < people - 1; idx++) {
            line.drawLine(new RandomUtil().getBoolean(), idx);
        }
        return line;
    }

    public List<Line> getLadder() {
        return this.ladders;
    }
}
