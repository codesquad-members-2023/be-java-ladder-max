package kr.codesquad;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputNumberOfUsers() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return Integer.parseInt(SCANNER.nextLine());
    }
}
