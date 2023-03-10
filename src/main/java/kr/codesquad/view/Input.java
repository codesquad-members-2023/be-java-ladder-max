package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Input {
    public int inputLadder(BufferedReader br) throws IOException {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            int countOfLadder = Integer.parseInt(br.readLine());
            limitLadderSize(countOfLadder);
            return countOfLadder;
        } catch (NumberFormatException e) {
            System.out.println("정수가 아닙니다.");
            return inputLadder(br);
        } catch (IllegalArgumentException e) {
            System.out.println("사다리 높이는 0보다 커야 합니다.");
            return inputLadder(br);
        }
    }

    private void limitLadderSize(int countOfLadder) {
        if (countOfLadder <= 0) {
            throw new IllegalArgumentException(countOfLadder + "은 0보다 작습니다.");
        }
    }

    public ArrayList<String> inputNames(BufferedReader br) throws IOException {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String[] names = br.readLine().replaceAll(" ", "").split(",");
            limitNameSize(names);
            return new ArrayList<>(Arrays.asList(names));
        } catch (IllegalArgumentException e) {
            System.out.println("플레이어의 이름은 최대 5글자까지 가능합니다.");
            return inputNames(br);
        }
    }

    private void limitNameSize(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(name+ "은 5글자보다 큽니다.");
            }
        }
    }
}
