package kr.codesquad.domain;

import java.util.List;

public class Line {
    List<Boolean> line;

    public Line(List<Boolean> line){
        this.line = line;
    }

    public List<Boolean> getLine(int playerSize){
        return line;
    }
}
