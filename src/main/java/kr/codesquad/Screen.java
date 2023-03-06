package kr.codesquad;

import java.util.Scanner;

public class Screen {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputPlayerNumber() {
        System.out.println("참여할 사람은 몇 명인가요?");

        return scanner.nextInt();
    }
}
