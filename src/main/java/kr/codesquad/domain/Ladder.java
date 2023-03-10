package kr.codesquad.domain;

import kr.codesquad.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladders;
    private final int height;
    private final List<String> people;
    private final List<String> results;
    private final OutputView outputView;
    private final List<String> finals;

    public Ladder(List<String> people, List<String> results, int height) {
        this.people = people;
        this.results = results;
        this.height = height;
        this.ladders = new ArrayList<>(); // 출력할 때 | 추가할거임
        this.outputView = new OutputView();
        this.finals = new ArrayList<>();
        makeLadder();
        outputView.printAll(people, ladders, results);
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
        for (Line line : ladders) {
            curr = line.goLine(curr);
        }
        return curr;
    }

    private void makeLadder() {
        for(int idx = 0; idx < height; idx++) {
            ladders.add(makeLine());
        }
    }

    private Line makeLine() {
        Line line = new Line();
        for(int idx = 0; idx < people.size() - 1; idx++) {
            line.drawLine(new RandomUtil().getBoolean(), idx);
        }
        return line;
    }

    public void findResult(String input) {
        Type type = Type.find(input);
        if(executeType(type, input)) {
            return;
        }
        outputView.insertError();
    }

    private boolean executeType(Type type, String input) {
        if(type != null) {
            type.execute(finals, outputView);
            return true;
        }
        return findOne(input);
    }

    private boolean findOne(String input) {
        if (people.contains(input)) {
            outputView.printResults();
            System.out.println(finals.stream().map(o -> o.split( " : "))
                    .filter(o -> o[0].equals(input))
                    .findFirst()
                    .orElse(new String[] {"", "없는 이름이 로직을 탐."})[1]);
            return true;
        }
        return false;
    }
}
