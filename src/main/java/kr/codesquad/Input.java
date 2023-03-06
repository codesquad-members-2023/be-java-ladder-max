package kr.codesquad;

import java.util.Scanner;

public class Input {
    public int inputPlayers() {
        System.out.println("몇 분이서 오셨어요?");;
        Scanner scanner = new Scanner(System.in);
        int players = scanner.nextInt();

        return players;
    }

    public int inputHeight() {
        System.out.println("얼마나 길게 하려고?");
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();

        return height;
    }
}
