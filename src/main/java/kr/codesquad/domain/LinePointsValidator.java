package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class LinePointsValidator {

    private final String errorMessageForConsecutivePoints = "연속적인 true 존재";
    void validatePoints(ArrayList<Boolean> points) {
        try {
            validatePointsAndThrowException(points);
        }catch (RuntimeException e){
            System.out.println(e);
        }
    }

    private void validatePointsAndThrowException(ArrayList<Boolean> points){
        IntStream.range(0, points.size()-1)
                .filter(i ->points.get(i) && points.get(i + 1))
                .findFirst()
                .ifPresent(i -> {
                    throw new IllegalStateException(errorMessageForConsecutivePoints);
                });
    }
}
