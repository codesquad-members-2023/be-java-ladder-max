package kr.codesquad.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderLineTest {

    @Test
    @DisplayName("사람이 10000명일때 pointsValidate 성공 테스트")
    void pointsValidateSuccessTest() {
        LadderLine line = new LadderLine(10000);
        line.createLine();
        //org.junit.jupiter.api.Assertions 로 테스트
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> line.pointsValidate());
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                line.pointsValidate();
            }
        });

        //org.assertj.core.api.Assertions 으로 테스트
        org.assertj.core.api.Assertions.assertThatCode(() -> line.pointsValidate()).doesNotThrowAnyException();

        org.assertj.core.api.Assertions.assertThatCode(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                line.pointsValidate();
            }
        }).doesNotThrowAnyException();

    }

    @Test
    @DisplayName("사람이 10000명일때 pointsValidate 실패 테스트")
    void pointsValidatefailTest() {
        LadderLine line = new LadderLine(10000);
        line.createLine();
        line.points.add(true);
        line.points.add(true);
        //org.junit.jupiter.api.Assertions 로 테스트
        assertThrows(IllegalStateException.class, () -> line.pointsValidate());

        //org.assertj.core.api.Assertions 으로 테스트
        assertThatThrownBy(() -> line.pointsValidate()).isInstanceOf(IllegalStateException.class);
    }
}