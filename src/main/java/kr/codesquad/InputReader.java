package kr.codesquad;

import java.util.Scanner;
import java.util.ArrayList;

public class InputReader {
    Scanner sc = new Scanner(System.in);
    private int ladderHeight;
    private ArrayList<String> namesList = new ArrayList<>();
    private boolean continueUntilAllNameIn5 = true;

    public void startLadderGame() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표로 구분하세요)");
        makeNamesList();
        checkNameLength();
        reInputIfNameOver5();
        setLadderHeight();
    }

    private void checkNameLength() {
        for (int i = 0; i < namesList.size(); i++) {
            if (namesList.get(i).length() > 5) {
                continueUntilAllNameIn5 = true;
                break;
            }
            if (namesList.get(i).length() < 6) {
                continueUntilAllNameIn5 = false;
            }
        }
    }

    private void reInputIfNameOver5() {
        while (continueUntilAllNameIn5) {
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

    private void setLadderHeight() {
        System.out.println("사다리 층 수는 몇인가요?");
        ladderHeight = sc.nextInt();
    }

    public int getLadderHeight() {

        return ladderHeight;
    }

    public ArrayList<String> getNamesList() {

        return namesList;
    }
}
