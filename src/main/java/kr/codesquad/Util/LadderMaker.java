package kr.codesquad.Util;

import kr.codesquad.Domain.Line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderMaker {
    public List<Line> makeLadder(Integer width, Integer height){
        return Stream.generate(() -> new Line(width)).limit(height).collect(Collectors.toList());
    }

}
