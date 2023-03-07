package kr.codesquad;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String tmp = scanner.nextLine();
        String[] player = tmp.split(",");
        int c = (player.length*2)-1;
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int r = scanner.nextInt();

        Ladder la = new Ladder(r,c);
        la.printLadder();
    }
}
