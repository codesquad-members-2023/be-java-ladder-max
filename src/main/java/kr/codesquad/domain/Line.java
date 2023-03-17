package kr.codesquad.domain;

import java.util.ArrayList;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();

    public boolean hasBridge(int i) {
        return points.get(i);
    }

    public int size() {
        return points.size();
    }

    public void add(boolean point) {
        points.add(point);
    }
}
