package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class LinePointsValidator {

    private final String errorMessageForConsecutivePoints = "연속적인 true 존재";
    boolean validatePoints(ArrayList<Boolean> points) {
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
                    throw new IllegalStateException(errorMessageForConsecutivePoints);
                });
    }
}
