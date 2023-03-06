package kr.codesquad;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int c = (scanner.nextInt()*2)-1;
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int r = scanner.nextInt();

        Ladder la = new Ladder(r,c);
        la.printLadder();
    }
}