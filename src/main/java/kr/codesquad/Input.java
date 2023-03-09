package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Input {
    public int input(BufferedReader br) throws IOException {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            return Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            System.out.println("정수가 아닙니다.");
            return input(br);
        }
    }

    public ArrayList<String> inputNames(BufferedReader br) throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] names = br.readLine().replaceAll(" ", "").split(",");
        for (String name : names) {
            limitNameSize(name, br);
        }
        return new ArrayList<>(Arrays.asList(names));
    }

    private void limitNameSize(String name, BufferedReader br) throws IOException {
        if (name.length() > 5) {
            System.out.println("플레이어의 이름은 최대 5글자까지 가능합니다.");
            inputNames(br);
        }
    }
}
