package kr.codesquad.domain;

public class LadderGenerator {
    private final int LAST_INDEX = 1;
    private final int INDEX_START_ZERO = 0;
    private final int WIDTH_MULTI_NUMBER = 2;

    public Ladder make(Users users, int ladderHeight) {
        int ladderWidth = users.count() * WIDTH_MULTI_NUMBER - LAST_INDEX;
        return makeLine2Ladder(ladderHeight, ladderWidth);
    }

    private Ladder makeLine2Ladder(int ladderHeight, int ladderWidth) {
        Line line;
        Ladder ladder = new Ladder();
        for (int i = INDEX_START_ZERO; i < ladderHeight; i++) {
            line = new Line();
            line.fillLadder(ladderWidth);
            ladder.add(line);
        }
        return ladder;
    }
}
