package kr.codesquad;

import java.util.Scanner;

public class Input {
    private static final String INPUT_PLAYERS_MESSAGE = "몇분이서 오셨어요?";
    private static final String INPUT_HEIGHT_MESSAGE = "얼마나 길게 하려고?";

    public int inputPlayers() {
        System.out.println(INPUT_PLAYERS_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        int players = scanner.nextInt();

        return players;
    }

    public int inputHeight() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();

        return height;
    }
}
