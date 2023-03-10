package kr.codesquad.domain;

public class LineStateRandomCreator {

    public LinesInfo create(int namesSize, int ladderHeight) {
        LinesInfo linesInfo = new LinesInfo();
        for (int i = 0; i < ladderHeight; i++) {
            linesInfo.add(LineInfo.createRandomLineStateInfo(namesSize));
        }
        return linesInfo;
    }
}
