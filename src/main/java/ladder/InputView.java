package ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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

    public String[] getNamesOfParticipants() {
        System.out.println("참여할 사람의 이름을 입력하세요. 이름은 쉼표로 구분하세요. 하나의 이름은 최대 5글자까지 입력이 가능합니다.");
        try {
            return validateNameLength(divideByComma(readInput()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getNamesOfParticipants();
        }
    }

    private String[] divideByComma(String input) {
        return input.split(",");
    }

    private String[] validateNameLength(String[] names) {
        if (Arrays.stream(names).anyMatch(name -> name.length() > 5)) {
            throw new RuntimeException("이름의 길이는 최대 5글자입니다.");
        }
        return names;
    }

    public int getNumberOfLadderHeight() {
        System.out.println("사다리 높이는 몇 개인가요?");
        return Integer.parseInt(readInput());
    }

    public void stop() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException("InputView 종료 시 문제 발생");
        }
    }
}
