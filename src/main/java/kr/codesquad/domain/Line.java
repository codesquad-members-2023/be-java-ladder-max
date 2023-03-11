package kr.codesquad.domain;

public class Line {

    public boolean isLine(String before) {
        if (before.equals(LadderLine.stick.getValue())) {
            return true;
        }
        return false;
    }
}
