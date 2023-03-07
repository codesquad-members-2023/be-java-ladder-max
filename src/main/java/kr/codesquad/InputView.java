package kr.codesquad.view;

import java.util.Scanner;

public class InputView {
    Scanner sc = new Scanner(System.in);

    public int userInput() {
        int input = sc.nextInt();
        return input;
    }
}
