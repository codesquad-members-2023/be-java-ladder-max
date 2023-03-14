package kr.codesquad.domain;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public String getPlayers() {
        System.out.print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public int getRow() {
        System.out.print("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}