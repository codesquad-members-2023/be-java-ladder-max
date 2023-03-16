package kr.codesquad.ladder.view;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kr.codesquad.ladder.domain.Name;
import kr.codesquad.ladder.domain.Names;
import kr.codesquad.ladder.view.LadderConsoleReader;
import kr.codesquad.ladder.view.LadderConsoleWriter;
import kr.codesquad.ladder.view.LadderReader;
import kr.codesquad.ladder.view.LadderWriter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderConsoleReaderTest {

    private static final Pattern DELIMITER = Pattern.compile("\\s*,\\s*");

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
        String[] actual = ladderReader.readNamesOfPeoples();
        //then
        String[] expected = input.split(DELIMITER.pattern());
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private InputStream toInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @DisplayName("인원수에 따른 실행 결과들이 입력되는지 테스트")
    @ValueSource(strings = {"꽝,5000,꽝,3000"})
    public void readLadderResults(String input) {
        //given
        reader = new BufferedReader(new InputStreamReader(toInputStream(input)));
        ladderWriter = new LadderConsoleWriter();
        ladderReader = new LadderConsoleReader(reader, ladderWriter);
        //when
        String[] actual = ladderReader.readDestinations();
        //then
        String[] expected = input.split(DELIMITER.pattern());
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("인원수에 따른 실행 결과들이 입력되는지 테스트")
    public void readLadderResults() {
        //given
        String input = "5";
        reader = new BufferedReader(new InputStreamReader(toInputStream(input)));
        ladderWriter = new LadderConsoleWriter();
        ladderReader = new LadderConsoleReader(reader, ladderWriter);
        //when
        int actual = ladderReader.readMaximumLadderHeight();
        //then
        int expected = 5;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("사다리 실행 결과를 보고 싶은 이름을 입력받는 테스트")
    public void readNameForLadderResult_success() {
        //given
        String[] nameArray = {"pobi", "honux", "crong", "jk"};
        Names names = new Names(createNameList(nameArray));
        String input = "pobi";
        reader = new BufferedReader(new InputStreamReader(toInputStream(input)));
        ladderWriter = new LadderConsoleWriter();
        ladderReader = new LadderConsoleReader(reader, ladderWriter);
        //when
        String actual = ladderReader.readNameOfPeopleForLadderResult(names);
        //then
        Assertions.assertThat(actual).isEqualTo(input);
    }

    @Test
    @DisplayName("사다리 실행 결과를 보기 위해서 all을 입력받는 테스트")
    public void readNameForLadderResult_success2() {
        //given
        String[] nameArray = {"pobi", "honux", "crong", "jk"};
        Names names = new Names(createNameList(nameArray));
        String input = "all";
        reader = new BufferedReader(new InputStreamReader(toInputStream(input)));
        ladderWriter = new LadderConsoleWriter();
        ladderReader = new LadderConsoleReader(reader, ladderWriter);
        //when
        String actual = ladderReader.readNameOfPeopleForLadderResult(names);
        //then
        Assertions.assertThat(actual).isEqualTo(input);
    }

    private List<Name> createNameList(String[] nameArray) {
        List<Name> nameList = new ArrayList<>();
        for (String name : nameArray) {
            nameList.add(new Name(name));
        }
        return nameList;
    }
}
