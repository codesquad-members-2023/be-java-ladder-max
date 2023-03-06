package kr.codesquad.Domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    private List<Boolean> points;
    public Line(Integer width){
        this.points = Stream.generate(() -> new Random().nextBoolean())
                .limit(width)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        String lineString = points.stream()
                .map(i -> i ? "-|" : " |")
                .collect(Collectors.joining(""));
        return "|" + lineString;
    }

}
