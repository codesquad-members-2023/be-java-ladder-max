package ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private final BufferedReader bufferedReader;

    public InputView() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private String readInput() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("입력 형식이 올바르지 않습니다.");
        }
    }

    public int getNumberOfParticipants() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return Integer.parseInt(readInput());
    }

    public int getNumberOfLadderHeight() {
        System.out.println("사다리 높이는 몇 개인가요?");
        return Integer.parseInt(readInput());
    }
}
