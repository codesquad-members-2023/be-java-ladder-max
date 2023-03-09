package ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class View {
    private final BufferedReader bufferedReader;

    public View() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public List<String> getNamesOfPlayers() {
        System.out.println("참여할 사람의 이름을 입력하세요. 이름은 쉼표로 구분하세요. 하나의 이름은 최대 5글자까지 입력이 가능합니다.");
        return divideByComma(readInput());
    }

    private String readInput() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("입력 형식이 올바르지 않습니다.");
        }
    }

    private List<String> divideByComma(String input) {
        return Arrays.stream(input.split(",")).collect(Collectors.toList());
    }

    public int getLadderHeight() {
        System.out.println("사다리 높이는 몇 개인가요?");
        return Integer.parseInt(readInput());
    }

    public void stop() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException("View 종료 시 문제 발생");
        }
    }

    public void print(String string) {
        System.out.println(string);
    }
}
