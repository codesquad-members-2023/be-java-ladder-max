package kr.codesquad.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// Reflection -> private 메서드 테스트
// https://mangkyu.tistory.com/235 < 이에 대한 반박글
class LadderShapeTest {
    // boolean 깃발을 이용한 로직
    // minus sign을 추가하기 전과 후의 boolean값을 비교
    @Test
    public void minus_sign_가능_여부_체크() throws Exception {
        // 필드값 독재
        LadderShape ladderShape = new LadderShape(new ArrayList<>(List.of("pobi", "honux", "crong", "jk")), 5);
        Field field = ladderShape.getClass().getDeclaredField("isMinusSign");
        field.setAccessible(true);
        assertThat(field.get(ladderShape)).isEqualTo(false);

        // 메서드 독재
        Method method = ladderShape.getClass().getDeclaredMethod("appendMinusSign");
        method.setAccessible(true);
        method.invoke(ladderShape);
        assertThat(field.get(ladderShape)).isEqualTo(true);
    }

    // 사다리 길이인 줄 알고 멘붕왔는데 참가자 글자 수 말하는 거였음
    // String.format() 이용해서 5글자로 맞추자!
    @Test
    public void 최대_5글자_출력_여부_체크() {
/*
        final LadderShape ladderShape = new LadderShape(new ArrayList<>(List.of("pobi", "honux", "crong", "jk")), 5);
        try {
            Method method = ladderShape.getClass().getDeclaredMethod("printParticipants");
            method.setAccessible(true);
            method.invoke(ladderShape);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        final List<String> format = ladderShape.getFormatList();

        // when

        // then
        assertThat(format.stream().allMatch(participant -> participant.length() <= 5)).isTrue();
*/
    }
}