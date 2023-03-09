package kr.codesquad;

import java.util.ArrayList;
import java.util.Random;

public class Row {
    private final ArrayList<Boolean> points;

    public Row(int countOfPerson) {
        points = makeRow(countOfPerson);
    }

    private ArrayList<Boolean> makeRow(int countOfPerson) {
        ArrayList<Boolean> row = new ArrayList<>();
        for (int i = 0; i < countOfPerson - 1; i++) {
            row.add(checkPossiblity(row, i));
        }
        return row;
    }

    private boolean checkPossiblity(ArrayList<Boolean> row, int index) {
        Random rd = new Random();
        if (index == 0) {
            return rd.nextBoolean();
        }
        if (row.get(index - 1)) {
            return false;
        }
        return rd.nextBoolean();
    }

    public boolean getBool(int i) {
        return points.get(i);
    }
}
