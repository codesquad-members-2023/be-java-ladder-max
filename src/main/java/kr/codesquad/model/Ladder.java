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
        for (int i = 0; i < length; i++) {
            List<String> lines = new ArrayList<>();
            lines.add("|");
            String before = "";
            for (int j = 1; j < width; j += 2) {
                if (before.equals(LadderLine.stick.getValue())) {
                    before = LadderLine.blank.getValue();
                } else {
                    before = LadderLine.takeRandom();
                }
                lines.add(before);
                lines.add("|");
            }
            laddersFrame.add(lines);
        }
    }



}
