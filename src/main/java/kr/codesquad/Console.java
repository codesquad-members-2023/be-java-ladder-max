package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
  private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public String input(String prompt) throws IOException {
    System.out.println(prompt);
    return br.readLine();
  }

  public void inputError() {
    System.out.println("입력이 잘못되었습니다.");
  }
}
