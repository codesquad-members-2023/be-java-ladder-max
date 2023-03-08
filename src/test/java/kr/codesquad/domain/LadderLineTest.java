package kr.codesquad.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LadderLineTest {

    @Test
    @DisplayName("사람이 10000명일때 pointsValidate 성공 테스트")
    void pointsValidateSuccessTest() {
        LadderLine line = new LadderLine(10000);
        line.createLine();
        assertDoesNotThrow(() -> line.pointsValidate());
    }

    @Test
    @DisplayName("사람이 10000명일때 pointsValidate 실패 테스트")
    void pointsValidatefailTest() {
        LadderLine line = new LadderLine(10000);
        line.createLine();
        line.points.add(true);
        line.points.add(true);
        assertThrows(IllegalStateException.class, () -> line.pointsValidate());
    }
}