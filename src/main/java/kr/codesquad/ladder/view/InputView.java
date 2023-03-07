package kr.codesquad.ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private final String REQUEST_PARTICIPANT_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final String REQUEST_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private final String NAME_SEPARATOR = ",";
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public List<String> inputNames() throws IOException {
        System.out.println(REQUEST_PARTICIPANT_NAME_MESSAGE);
        return Arrays.asList(bufferedReader.readLine().split(NAME_SEPARATOR));
    }

    public int inputHeight() throws IOException {
        System.out.println(REQUEST_LADDER_HEIGHT_MESSAGE);
        return Integer.parseInt(bufferedReader.readLine());
    }

}
