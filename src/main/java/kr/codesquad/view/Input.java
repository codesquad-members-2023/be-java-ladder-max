package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;

public class Input {
    public String input(BufferedReader br, int index) throws IOException {
        String[] answer = {"참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"
                ,"최대 사다리 높이는 몇 개인가요?"};
        System.out.println(answer[index]);
        return br.readLine();
    }

    private void limitLadderSize(int countOfLadder) {
        if (countOfLadder <= 0) {
            throw new IllegalArgumentException(countOfLadder + "은 0보다 작습니다.");
        }
    }

    public String[] splitNames(String answer) {
        return answer.replaceAll(" ", "").split(",");
    }

    public boolean validateNames(String[] names) {
        try {
            NamesToName(names);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("플레이어의 이름은 1글자부터 최대 5글자까지 가능합니다.");
            return false;
        }
    }
    private void NamesToName(String[] names) {
        for (String name : names) {
            limitNameSize(name);
        }
    }

    private void limitNameSize(String name) {
        if (name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException(name+ "은 형식에 맞지 않습니다.");
        }
    }
}
