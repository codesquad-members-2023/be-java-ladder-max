package kr.codesquad.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLineGenerator {

    private static Validator validator;

    public RandomLineGenerator(){
        this.validator = new Validator();
    }

    public Boolean buildLadderLine(int lineWidth,ArrayList<Boolean> points) {
        IntStream.range(0, lineWidth)
                .mapToObj(i -> generateRungStatus(points))
                .forEach(points::add);
        return validator.validatePoints(points);
    }

    private boolean generateRungStatus(List<Boolean> points) {
        if (points.isEmpty()) {
            return new Random().nextBoolean();
        }
        return new Random().nextBoolean() && !points.get(points.size() - 1);
    }
}
