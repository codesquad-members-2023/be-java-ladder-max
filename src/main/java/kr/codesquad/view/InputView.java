package kr.codesquad.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int getN() {
        OutputView.printInputN();
        return scanner.nextInt();
    }

    public int getMaxHeight() {
        OutputView.printInputMaxHeight();
        return scanner.nextInt();
    }
}
