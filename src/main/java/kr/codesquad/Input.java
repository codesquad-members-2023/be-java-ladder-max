package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    public static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(br.readLine());
        }catch (NumberFormatException e) {
            System.out.println("정수가 아닙니다.");
            return input();
        }
    }
}
