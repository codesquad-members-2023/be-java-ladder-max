package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class LinesInfo {

    private final List<LineInfo> linesInfo;

    public LinesInfo() {
        this.linesInfo = new ArrayList<>();
    }

    public void add(LineInfo lineInfo) {
        linesInfo.add(lineInfo);
    }


    public static LinesInfo create(int namesSize, int ladderHeight) {
        LinesInfo linesInfo = new LinesInfo();
        for (int i = 0; i < ladderHeight; i++) {
            linesInfo.add(LineInfo.createRandomLineInfo(namesSize - 1));
        }
        return linesInfo;
    }



    public String draw() {
        StringBuilder result = new StringBuilder();
        linesInfo.forEach(lineInfo ->
                result.append(lineInfo.drawLine()));
        return result.toString();
    }

    public void calculatorAndSaveResult(LadderResultRepository ladderResultRepository, List<String> names,
            List<String> resultInfo) {
        for (int i = 0; i < names.size(); i++) {
            int resultNum = i;
            for (LineInfo lineInfo : linesInfo) {
                resultNum = lineInfo.move(resultNum);
            }
            ladderResultRepository.put(names.get(i), resultInfo.get(resultNum));
        }
    }

    public int size() {
        return linesInfo.size();
    }
}
