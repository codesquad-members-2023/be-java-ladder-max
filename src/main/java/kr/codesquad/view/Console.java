package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class Console {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Optional<String> input(String prompt) {
        System.out.println(prompt);
        try {
            return Optional.of(br.readLine());
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    public void inputError() {
        System.out.println("입력이 잘못되었습니다.");
    }
}
