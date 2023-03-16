package kr.codesquad.view;

import java.util.Scanner;

public class InputView {
    private Scanner sc = new Scanner(System.in);

    public String userInput() {
        return sc.nextLine();
    }
}
