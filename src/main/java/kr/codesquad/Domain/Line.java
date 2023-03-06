package kr.codesquad.Domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    private List<Boolean> points;
    public Line(Integer width){
        this.points = Stream.concat(Stream.generate(() -> new Random().nextBoolean())
                .limit(width-1), Stream.of(false)).collect(Collectors.toList());
        Collections.shuffle(points);
    }

    @Override
    public String toString() {
        String lineString = points.stream()
                .map(i -> i ? "----|" : "    |")
                .collect(Collectors.joining(""));
        return "|" + lineString;
    }

}
