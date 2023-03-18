package kr.codesquad.view;

import java.util.Scanner;
import java.util.ArrayList;

public class InputView {
    Scanner namesReader = new Scanner(System.in);
    private int ladderHeight;
    private ArrayList<String> namesList = new ArrayList<>();
    private boolean continueUntilAllNameMax5 = true;

    public void startLadderGame() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표로 구분하세요)");
        makeNamesList();
        checkNameLength();
        nameLengthValidation();
        setLadderHeight();
    }

    private void makeNamesList() {
        for (String namesStrings : namesReader.nextLine().split(",")) {
            namesList.add(namesStrings);
        }
    }

    private void checkNameLength() {
        for (int namesListIndex = 0; namesListIndex < namesList.size(); namesListIndex++) {
            if (namesList.get(namesListIndex).length() > 5) {
                continueUntilAllNameMax5 = true;
                return;
            }
            if (namesList.get(namesListIndex).length() < 6) {
                continueUntilAllNameMax5 = false;
            }
        }
    }

    private void nameLengthValidation() {
        while (continueUntilAllNameMax5) {
            System.out.println("이름 1개당 5글자까지만 됩니다. 다시 해주세요. (이름은 쉼표로 구분하세요)");
            namesList.clear();
            makeNamesList();
            checkNameLength();
        }
    }

    private void setLadderHeight() {
        System.out.println("사다리 층 수는 몇인가요?");
        ladderHeight = namesReader.nextInt();
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public ArrayList<String> getNamesList() {
        return namesList;
    }
}
