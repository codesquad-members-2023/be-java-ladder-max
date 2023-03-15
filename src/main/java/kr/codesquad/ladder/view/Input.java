package kr.codesquad.ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static int ladderLength() throws IOException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return  Integer.parseInt(bufferedReader.readLine());
    }

    public static   String insertUser() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return bufferedReader.readLine();
    }

    public static   String insertResult() throws IOException {
        System.out.println("결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return bufferedReader.readLine();
    }
}
