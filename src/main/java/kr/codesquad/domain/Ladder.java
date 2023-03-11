package kr.codesquad.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final int height;
    private final List<String> people;
    private final List<String> results;
    private final List<String> finals;

    public Ladder(List<String> people, List<String> results, int height) {
        this.people = people;
        this.results = results;
        this.height = height;
        this.lines = new ArrayList<>(); // 출력할 때 | 추가할거임
        this.finals = new ArrayList<>();
        makeLadder();
        saveResults();
    }

    private void saveResults() {
        for(int idx = 0; idx < people.size(); idx++) {
            int curr = goLadder(idx);
            finals.add(people.get(idx) + " : " + results.get(curr));
        }
    }

    private int goLadder(int idx) {
        int curr = idx;
        for (Line line : lines) {
            curr = line.goLine(curr);
        }
        return curr;
    }

    private void makeLadder() {
        for(int idx = 0; idx < height; idx++) {
            lines.add(makeLine());
        }
    }

    private Line makeLine() {
        Line line = new Line();
        for(int idx = 0; idx < people.size() - 1; idx++) {
            line.drawLine(new RandomUtil().getBoolean(), idx);
        }
        return line;
    }

    public List<String> getPeople() {
        return Collections.unmodifiableList(this.people);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(this.results);
    }

    public List<String> getFinals() {
        return Collections.unmodifiableList(this.finals);
    }
}
