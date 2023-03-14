package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final String BLANK = " ";
    private final String VERTICAL_LINE = "|";
    private final int NAME_BLANK = 6;
    private final int LAST_INDEX = 1;
    private final int ODD_INDEX_START = 1;
    private final int ODD_INDEX_JUMP = 2;
    private final int INDEX_START_ZERO = 0;
    private final String EMPTY_STRING = "";

    private List<List<String>> laddersFrame = new ArrayList<>();
    private int length;
    private int width;
    private Line line;

    public Ladder(Line line) {
        this.line = line;
    }

    public List<List<String>> makeLadder(List<String> users, int ladderNumber) {
        init(users, ladderNumber);
        makeName2Ladder(users);
        makeLine2Ladder();
        return laddersFrame;
    }

    private void init(List<String> users, int ladderNumber) {
        width = users.size() + (users.size() - LAST_INDEX);
        length = ladderNumber;
    }

    // 유저 이름들을 사다리 리스트에 넣는 메서드, 이름이 들어가지 않는 부분은 (6-이름길이)만큼 공백 넣어줌
    private void makeName2Ladder(List<String> users) {
        List<String> userNames = new ArrayList<>();
        for (String user : users) {
            userNames.add(user);
            userNames.add(BLANK.repeat(NAME_BLANK - user.length()));
        }
        userNames.remove(userNames.size() - LAST_INDEX);
        laddersFrame.add(userNames);
    }

    private void makeLine2Ladder() {
        List<String> lines;
        for (int i = INDEX_START_ZERO; i < length; i++) {
            lines = new ArrayList<>();
            lines.add(VERTICAL_LINE);
            fillLadderWidth(lines);
            laddersFrame.add(lines);
        }
    }

    private void fillLadderWidth(List<String> lines) {
        String before = EMPTY_STRING;
        for (int j = ODD_INDEX_START; j < width; j += ODD_INDEX_JUMP) {
            before = fillLadderRandomOrStick(before);
            lines.add(before);
            lines.add(VERTICAL_LINE);
        }
    }

    private String fillLadderRandomOrStick(String before) {
        if (line.isLine(before)) {
            return LadderLine.blank.getValue();
        }
        return LadderLine.takeRandom();
    }
}
