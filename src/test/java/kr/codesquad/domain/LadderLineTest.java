package kr.codesquad.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LadderLineTest {

    RandomLineGenerator rg = new RandomLineGenerator();

    @Test
    @DisplayName("사람이 10000명일때 pointsValidate 성공 테스트")
    void pointsValidateSuccessTest() {
        ArrayList<Boolean> points = new ArrayList<>();
        Assertions.assertTrue(() -> rg.buildLadderLine(10000, points));
    }

    @Test
    @DisplayName("사람이 10000명일때 pointsValidate 실패 테스트")
    void pointsValidatefailTest() {
        ArrayList<Boolean> points = new ArrayList<>();
        points.add(true);
        points.add(true);
        Assertions.assertFalse(() -> rg.buildLadderLine(10000, points));
    }
}