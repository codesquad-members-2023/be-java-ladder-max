package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class LineStateRandomCreator {
    public List<LineInfo> create(int namesSize, int ladderHeight) {
        List<LineInfo> linesStateInfo = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            linesStateInfo.add(LineInfo.createRandomLineStateInfo(namesSize));
        }
        return linesStateInfo;
    }

}
