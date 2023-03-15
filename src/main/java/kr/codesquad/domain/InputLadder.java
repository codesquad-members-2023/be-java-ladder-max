package kr.codesquad.domain;

import java.util.Scanner;

public class InputLadder {
    private Scanner scanner;

    public InputLadder() {
        scanner = new Scanner(System.in);
    }

    public String inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public int inputRow() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
    public String inputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }
}