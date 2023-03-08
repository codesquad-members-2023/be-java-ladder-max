package kr.codesquad.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final String BLANK = " ";
    private final String VERTICAL_LINE = "|";

    private List<List<String>> laddersFrame = new ArrayList<>();
    private int length;
    private int width;

    public List<List<String>> makeLadder(List<String> users, int m) {
        init(users, m);
        makeName2Ladder(users);
        makeLine2Ladder();
        return laddersFrame;
    }

    private void init(List<String> users, int m) {
        width = users.size() + (users.size() - 1);
        length = m;
    }

    // 유저 이름들을 사다리 리스트에 넣는 메서드, 이름이 들어가지 않는 부분은 (6-이름길이)만큼 공백 넣어줌
    private void makeName2Ladder(List<String> users) {
        List<String> userNames = new ArrayList<>();
        for (String user : users) {
            userNames.add(user);
            userNames.add(BLANK.repeat(6 - user.length()));
        }
        userNames.remove(userNames.size() - 1);
        laddersFrame.add(userNames);
    }

    private void makeLine2Ladder() {
        List<String> lines;
        for (int i = 0; i < length; i++) {
            lines = new ArrayList<>();
            lines.add(VERTICAL_LINE);
            fillLadderWidth(lines);
            laddersFrame.add(lines);
        }
    }

    private void fillLadderWidth(List<String> lines) {
        String before = "";
        for (int j = 1; j < width; j += 2) {
            before = fillLadderRandomOrStick(before);
            lines.add(before);
            lines.add(VERTICAL_LINE);
        }
    }

    private String fillLadderRandomOrStick(String before) {
        if (before.equals(LadderLine.stick.getValue())) {
            return LadderLine.blank.getValue();
        }
        return LadderLine.takeRandom();
    }
}
