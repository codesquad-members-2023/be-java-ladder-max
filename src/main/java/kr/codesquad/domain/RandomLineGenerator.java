package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLineGenerator {

    private static final String ERROR_MESSAGE_FOR_CONSECUTIVE_POINTS = "연속적인 true 존재";

    public Boolean buildLadderLine(int lineWidth,ArrayList<Boolean> points) {
        IntStream.range(0, lineWidth)
                .mapToObj(i -> generateRungStatus(points))
                .forEach(points::add);
        return validatePoints(points);
    }

    private boolean generateRungStatus(List<Boolean> points) {
        if (points.isEmpty()) {
            return new Random().nextBoolean();
        }
        return new Random().nextBoolean() && !points.get(points.size() - 1);
    }

    private boolean validatePoints(ArrayList<Boolean> points) {
        try {
            validatePointsAndThrowException(points);
            return true;
        }catch (IllegalStateException e){
            System.out.println(e);
        }
        return false;
    }

    private void validatePointsAndThrowException(ArrayList<Boolean> points){
        IntStream.range(0, points.size()-1)
                .filter(i ->points.get(i) && points.get(i + 1))
                .findFirst()
                .ifPresent(i -> {
                    throw new IllegalStateException(ERROR_MESSAGE_FOR_CONSECUTIVE_POINTS);
                });
    }

}
