
package kr.codesquad;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        enterCommand();
    }

    private static void enterCommand() {
        System.out.println("참여할 사람은 몇 명인가요?");
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();

        Ladder ladder = new Ladder(people, height);
        ladder.printLadder();
    }
}