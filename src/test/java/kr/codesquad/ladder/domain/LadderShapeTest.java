package kr.codesquad.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderShapeTest {
    @Test
    public void minus_sign_가능_여부_체크() {
        // given

        // when

        // then
    }

    // 사다리 길이인 줄 알고 멘붕왔는데 참가자 글자 수 말하는 거였음
    // String.format() 이용해서 5글자로 맞추자!
    @Test
    public void 최대_5글자_출력_여부_체크() {
        // given
        final LadderShape ladderShape = new LadderShape(new ArrayList<>(List.of("pobi", "honux", "crong", "jk")), 5);
        ladderShape.printParticipants();

        // when
        final List<String> format = ladderShape.getFormatList();

        // then
        assertThat(format.stream().allMatch(participant -> participant.length() <= 5)).isTrue();
    }
}