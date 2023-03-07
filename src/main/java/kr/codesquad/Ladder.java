package kr.codesquad;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private int ladderWidth;
    private int ladderHeight;
    private ArrayList ladder = new ArrayList();
    private ArrayList<String> nameList = new ArrayList<>();

    public Ladder(ArrayList list) {
        init(list);
        makeLadder();
    }

    private void init(ArrayList list) {
        ladderHeight = Integer.parseInt(list.get(list.size() - 1).toString());
        list.remove(list.size() - 1);
        nameList.addAll(list);
        ladderWidth = nameList.size();
    }

    void makeLadder() {
        for (String str : nameList) {
            while (str.length() < 5) {
                if (str.length() < 5) {
                    str += " ";
                }
            }
            str = " " + str;
            ladder.add(str);
        }
        ladder.add("\n");

        for (int i = 0; i < ladderHeight; i++) {
            ladder.add("  ");
            for (int j = 0; j < (ladderWidth) * 2 - 1; j++) {
                if (j % 2 != 0) {
                    ladder.add(random() ? "-----" : "     ");

                } else {
                    ladder.add("|");
                }
            }
            ladder.add("\n");
        }

    }

    public ArrayList getLadder() {
        return ladder;
    }

    boolean random() {
        Random rd = new Random();
        return rd.nextBoolean();
    }
}
