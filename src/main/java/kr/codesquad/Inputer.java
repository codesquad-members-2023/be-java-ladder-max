package kr.codesquad;

import java.util.Scanner;

public class Inputer {
    Scanner sc = new Scanner(System.in);
    private String names;
    private int ladderNum;

    public void seting() {
        setManValue();
        setLadderValue();
    }

    private void setManValue() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표로 구분하세요)");
        names = sc.nextLine();
//        System.out.println(System.lineSeparator());
    }

    private void setLadderValue() {
        System.out.println("사다리 층 수는 몇층인가요?");
        ladderNum = sc.nextInt();
//        System.out.println(System.lineSeparator());
    }

    public String getNames() {
        String temp = names;
        return temp;
    }

    public int getLadderNum() {
        int temp = ladderNum;
        return temp;
    }
}