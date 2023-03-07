package kr.codesquad;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    int m;
    static int n;
    static ArrayList<ArrayList<String>> ladder;

    public void makeLadder(int people, int height) {
        m = people;
        n = height;
        ladder = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ladder.add(makeRow());
        }
    }

    public ArrayList<String> makeRow() {
        ArrayList<String> row = new ArrayList<>();
        row.add("|");
        for (int i = 0; i < m - 1; i++) {
            row.add(getHorizontalLine(row));
            row.add("|");
        }
        return row;
    }

    public String getHorizontalLine(ArrayList<String> row) {
        Random rd = new Random();
        if (row.size() < 3) {
            return (rd.nextBoolean()) ? "-----" : "     ";
        }
        if (!row.get(row.size() - 2).equals("-----")) {
            return (rd.nextBoolean()) ? "-----" : "     ";
        }
        return "     ";
    }
}