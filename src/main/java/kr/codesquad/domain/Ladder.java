package kr.codesquad.domain;

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

    public ArrayList getLadder() {
        return ladder;
    }

    private void init(ArrayList list) {
        ladderHeight = Integer.parseInt(list.get(list.size() - 1).toString());
        list.remove(list.size() - 1);
        nameList.addAll(list);
        ladderWidth = nameList.size();
    }


    private void makeLadder() {
        addNameToLadder();
        buildLadderStructure();
    }

    private void addNameToLadder() {
        for (String str : nameList) {
            String formattedStr = String.format(" %1$-5s", str);
            ladder.add(formattedStr);
        }
        ladder.add("\n");
    }

    private void buildLadderStructure() {
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add("  ");
            buildLadderDetailStructure();
            ladder.add("\n");
        }
    }

    private void buildLadderDetailStructure() {
        for (int j = 0; j < (ladderWidth) * 2 - 1; j++) {
            ladder.add(j % 2 == 0 ? "|" : (shouldAddLine() ? "-----" : "     "));
        }
    }

    private boolean shouldAddLine() {
        Random rand = new Random();
        return rand.nextBoolean() && !ladder.get(ladder.size() - 2).equals("-----");
    }
}
