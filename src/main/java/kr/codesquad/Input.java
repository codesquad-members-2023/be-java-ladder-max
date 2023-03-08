package kr.codesquad;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private final Scanner sc = new Scanner(System.in);

    public List<String> inputPlayers() {
        System.out.println("참가자 명부를 주시오");
        String[] splitPlayers = this.sc.nextLine().split(",");

        return Arrays.asList(splitPlayers);
    }

    public int inputHeight() {
        System.out.println("얼마나 길게 만들길 원하시오?");
        int height = this.sc.nextInt();

        return height;
    }
}
