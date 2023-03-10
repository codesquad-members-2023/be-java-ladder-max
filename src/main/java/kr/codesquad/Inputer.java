package kr.codesquad;

import java.util.Scanner;
import java.util.ArrayList;

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
    }

    public ArrayList<String> getNames() {
        ArrayList<String> arrayList = new ArrayList<>();

        do {
            for (int i = 0; i < names.split(",").length; i++) {
                if (names.split(",")[i].length() < 6) {
                    arrayList.add(names.split(",")[i]);
                }
                if (names.split(",")[i].length() > 5) {
                    System.out.println("이름 1개당 5글자까지만 됩니다. 다시 해주세요. (이름은 쉼표로 구분하세요)");
                    i = 0;
                }
            }
        } while (arrayList.size() != names.split(",").length);

        return arrayList;
    }

    private void setLadderValue() {
        System.out.println("사다리 층 수는 몇인가요?");
        ladderNum = sc.nextInt();
    }

    public int getLadderNum() {
        return ladderNum;
    }
}
