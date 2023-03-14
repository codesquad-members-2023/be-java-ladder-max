package kr.codesquad.ladder;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import kr.codesquad.ladder.domain.LadderResults;
import kr.codesquad.ladder.domain.Names;
import kr.codesquad.ladder.view.LadderConsoleReader;
import kr.codesquad.ladder.view.LadderConsoleWriter;
import kr.codesquad.ladder.view.LadderReader;
import kr.codesquad.ladder.view.LadderWriter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderGeneratorConsoleReaderTest {

    private BufferedReader reader;
    private LadderWriter ladderWriter;
    private LadderReader ladderReader;

    @ParameterizedTest
    @DisplayName("사용자 이름들이 제대로 받아지는지 테스트")
    @ValueSource(strings = {"pobi,honux,crong,jk", "pobi,  honux , crong   ,  jk"})
    public void readNameOfPeople_success(String input) {
        //given
        reader = new BufferedReader(new InputStreamReader(toInputStream(input)));
        ladderWriter = new LadderConsoleWriter();
        ladderReader = new LadderConsoleReader(reader, ladderWriter);
        //when
        Names actual = ladderReader.readNameOfPeople();
        //then
        Names expected = new Names(input, 2);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("사다리 게임 이름 입력중 이름의 글자가 5를 초과하여 예외가 발생하여 실패하는지 테스트")
    @ValueSource(strings = {"pobi,honux,crong,jkweifojaewiofj", "pobi,honux,crong,jk       "})
    public void readNameOfPeople_fail(String input) {
        //given
        reader = new BufferedReader(new InputStreamReader(toInputStream(input)));
        ladderWriter = new LadderConsoleWriter();
        ladderReader = new LadderConsoleReader(reader, ladderWriter);
        //when & then
        Assertions.assertThatThrownBy(() -> ladderReader.readNameOfPeople());
    }

    private InputStream toInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @DisplayName("인원수에 따른 실행 결과들이 입력되는지 테스트")
    @ValueSource(strings = {"꽝,5000,꽝,3000"})
    public void readLadderResults_success(String input) {
        //given
        reader = new BufferedReader(new InputStreamReader(toInputStream(input)));
        ladderWriter = new LadderConsoleWriter();
        ladderReader = new LadderConsoleReader(reader, ladderWriter);
        //when
        LadderResults actual = ladderReader.readLadderResults(4);
        //then
        LadderResults expected = new LadderResults(input, 4);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("인원수에 따른 실행결과 개수가 부족한지, 길이가 너무 긴지 확인하는 테스트")
    @ValueSource(strings = {"꽝,5000,꽝", "", " ", "꽝,5000,꽝,500000000"})
    public void readLadderResults_fail(String input) {
        //given
        reader = new BufferedReader(new InputStreamReader(toInputStream(input)));
        ladderWriter = new LadderConsoleWriter();
        ladderReader = new LadderConsoleReader(reader, ladderWriter);
        //when & then
        Assertions.assertThatThrownBy(() -> ladderReader.readLadderResults(4));
    }
}
