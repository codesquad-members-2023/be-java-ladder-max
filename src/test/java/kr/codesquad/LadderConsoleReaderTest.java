package kr.codesquad;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderConsoleReaderTest {

    private BufferedReader reader;
    private LadderValidator validator;
    private LadderWriter ladderWriter;
    private LadderReader ladderReader;


    @ParameterizedTest
    @DisplayName("사용자 이름들이 제대로 받아지는지 테스트")
    @ValueSource(strings = {"pobi,honux,crong,jk", "pobi,  honux , crong   ,  jk"})
    public void readNameOfPeople_success(String input) {
        //given
        reader = new BufferedReader(new InputStreamReader(toInputStream(input)));
        validator = new LadderValidator(2, 1);
        ladderWriter = new LadderConsoleWriter();
        ladderReader = new LadderConsoleReader(reader, validator, ladderWriter);
        //when
        List<String> actual = ladderReader.readNameOfPeople();
        //then
        List<String> expected = Arrays.stream(input.split("\\s*,\\s*"))
            .collect(Collectors.toList());
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("사용자 이름들이 제대로 받아지는지 테스트")
    @ValueSource(strings = {"pobi,honux,crong,jkweifojaewiofj", "pobi,honux,crong,jk    ", "pobi"})
    public void readNameOfPeople_fail(String input) {
        //given
        reader = new BufferedReader(new InputStreamReader(toInputStream(input)));
        validator = new LadderValidator(2, 1);
        ladderWriter = new LadderConsoleWriter();
        ladderReader = new LadderConsoleReader(reader, validator, ladderWriter);
        //when & then
        Assertions.assertThatThrownBy(() -> ladderReader.readNameOfPeople());
        Assertions.fail("이 테스트는 실패해야 합니다.");
    }

    private InputStream toInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}
