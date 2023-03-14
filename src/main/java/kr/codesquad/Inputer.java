package kr.codesquad;

import java.util.Scanner;
import java.util.ArrayList;

public class Inputer {
    Scanner sc = new Scanner(System.in);
    private int ladderNum;
    private ArrayList<String> namesList = new ArrayList<>();
    private boolean trueOrFalse = true;

    public void startLadder() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표로 구분하세요)");
        makeNamesList();
        checkNameLength();
        ifOver5();
        setLadderValue();
    }

    private void checkNameLength() {
        for (int i = 0; i < namesList.size(); i++) {
            if (namesList.get(i).length() > 5) {
                trueOrFalse = true;
                break;
            }
            if (namesList.get(i).length() < 6) {
                trueOrFalse = false;
            }
        }
    }

    private void ifOver5() {
        while (trueOrFalse) {
            System.out.println("이름 1개당 5글자까지만 됩니다. 다시 해주세요. (이름은 쉼표로 구분하세요)");
            namesList.clear();
            makeNamesList();
            checkNameLength();
        }
    }

    private void makeNamesList() {
        for (String j : sc.nextLine().split(",")) {
            namesList.add(j);
        }
    }

    private void setLadderValue() {
        System.out.println("사다리 층 수는 몇인가요?");
        ladderNum = sc.nextInt();
    }

    public int getLadderNum() {
        return ladderNum;
    }

    public ArrayList<String> getNamesList() {
        return namesList;
    }
}
