package kr.codesquad.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<List<String>> laddersFrame = new ArrayList<>();
    private int length;
    private int width;

    public List<List<String>> makeLadder(List<String> users, int m) {
        width = users.size() + (users.size() - 1);
        length = m;
        makeName2Ladder(users);
        makeLine2Ladder();
        return laddersFrame;
    }

    private void makeName2Ladder(List<String> users) {
        List<String> userNames = new ArrayList<>();
        for (String user : users) {
            userNames.add(user);
            userNames.add("");
        }
        userNames.remove(userNames.size() - 1);
        laddersFrame.add(userNames);
    }

    private void makeLine2Ladder() {
        List<String> lines;
        for (int i = 0; i < length; i++) {
            lines = new ArrayList<>();
            lines.add("|");
            fillLadderWidth(lines);
            laddersFrame.add(lines);
        }
    }

    private void fillLadderWidth(List<String> lines) {
        for (int j = 1; j < width; j += 2) {
            String before = "";
            before = fillLadderRandomOrStick(before);
            lines.add(before);
            lines.add("|");
        }
    }

    private String fillLadderRandomOrStick(String before) {
        if (before.equals(LadderLine.stick.getValue())) {
            return LadderLine.blank.getValue();
        }
        return LadderLine.takeRandom();
    }
}
