package kr.codesquad.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public String inputNames() {
        return sc.nextLine().trim();
    }

    public int inputLadderHeight() {
        return sc.nextInt();
    }


}
