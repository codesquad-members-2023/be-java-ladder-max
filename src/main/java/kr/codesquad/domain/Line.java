package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public boolean isLine(String before) {
        if (before.equals(LadderLine.stick.getValue())) {
            return true;
        }
        return false;
    }
}
