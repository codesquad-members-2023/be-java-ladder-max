package kr.codesquad;

import java.util.List;

public class LadderShape {
    private final List<String> participantList;
    private final int ladderShapeHeight;

    public LadderShape(List<String> participantList, int ladderShapeHeight) {
        this.participantList = participantList;
        this.ladderShapeHeight = ladderShapeHeight;
    }

    public void printLadderShape() {
        System.out.println(participantList);
    }
}
