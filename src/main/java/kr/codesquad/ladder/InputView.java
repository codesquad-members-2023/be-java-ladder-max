package kr.codesquad.ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private final String REQUEST_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private final String LADDER_HEIGHT_EXCEPTION_MESSAGE = "사다리의 높이는 숫자만 입력이 가능합니다.";
    private final String PARTICIPANT_COUNT_EXCEPTION_MESSAGE = "인원은 숫자만 입력이 가능합니다.";
    private final String REQUEST_PARTICIPANT_COUNT_MESSAGE = "참여할 사람은 몇 명인가요?";

    private final BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in));

    public int inputParticipantCount() {
        System.out.println(REQUEST_PARTICIPANT_COUNT_MESSAGE);
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(PARTICIPANT_COUNT_EXCEPTION_MESSAGE);
        }
    }

    public int inputLadderHeight() {
        System.out.println(REQUEST_LADDER_HEIGHT_MESSAGE);
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(LADDER_HEIGHT_EXCEPTION_MESSAGE);
        }
    }

}
