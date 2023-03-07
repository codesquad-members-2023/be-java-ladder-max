package kr.codesquad.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public List<String> getPeople() {
        OutputView.printInputPeople();
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public int getMaxHeight() {
        OutputView.printInputMaxHeight();
        return scanner.nextInt();
    }
}
