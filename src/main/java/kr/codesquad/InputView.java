package kr.codesquad;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int getN() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return scanner.nextInt();
    }

    public int getMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
