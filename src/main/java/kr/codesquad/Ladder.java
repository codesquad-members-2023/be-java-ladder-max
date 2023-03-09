package kr.codesquad;

import java.util.ArrayList;

public class Ladder {
    int countOfPerson;
    int ladderHeight;
    static ArrayList<Row> list;

    public void makeLadder(int m, int n) {
        countOfPerson = m;
        ladderHeight = n;
        list = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            list.add(new Row(countOfPerson));
        }
    }
}