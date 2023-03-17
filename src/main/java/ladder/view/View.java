package ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {
    private final BufferedReader bufferedReader;

    public View() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String[] getNamesOfPlayers() {
        System.out.println("\n참여할 사람의 이름을 입력하세요. 이름은 쉼표로 구분하세요. 하나의 이름은 최대 5글자까지 입력이 가능합니다.");
        return divideByComma(readInput());
    }

    private String readInput() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
        }
    }

    private String[] divideByComma(String input) {
        return input.split(",");
    }

    public int getLadderHeight() {
        System.out.println("\n사다리 높이는 몇 개인가요?");
        return Integer.parseInt(readInput());
    }

    public String[] getCategories() {
        System.out.println("\n카테고리를 입력하세요. 카테고리는 쉼표로 구분하세요. 하나의 카테고리는 최대 5글자까지 입력이 가능합니다.");
        return divideByComma(readInput());
    }

    public String getPlayerNameForResult() {
        System.out.println("\n결과를 확인하고 싶은 참가자 이름을 입력하세요.");
        return readInput();
    }

    public void stop() {
        try {
            System.out.println("\n게임을 종료합니다.");
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException("View 종료 시 문제 발생");
        }
    }

    public void print(String string) {
        System.out.println(string);
    }
}
