package kr.codesquad.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLineTest {

    LinePointsValidator linePointsValidator = new LinePointsValidator();

    @Test
    @DisplayName("사람이 10000명일때 pointsValidate 성공 테스트")
    void pointsValidateSuccessTest() {
        LadderLine line = new LadderLine(10000);
        line.createLine();
        Assertions.assertTrue(linePointsValidator.validatePoints(line.points));
    }

    @Test
    @DisplayName("사람이 10000명일때 pointsValidate 실패 테스트")
    void pointsValidatefailTest() {
        LadderLine line = new LadderLine(100);
        line.createLine();
        line.points.add(true);
        line.points.add(true);
        Assertions.assertFalse(linePointsValidator.validatePoints(line.points));
    }
}