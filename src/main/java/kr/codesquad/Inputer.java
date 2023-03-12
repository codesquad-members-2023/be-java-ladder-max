package kr.codesquad;

import java.util.Scanner;
import java.util.ArrayList;

public class Inputer {
    Scanner sc = new Scanner(System.in);
    private String names;
    private int ladderNum;

    public ArrayList<String> seting() {
        ArrayList<String> namesList = checkNameLength(makeNamesArrayList());
        setLadderValue();
        return namesList;
    }

    private ArrayList<String> makeNamesArrayList() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표로 구분하세요)");
        names = sc.nextLine();
        ArrayList<String> namesArrayList = new ArrayList<>();
        for (String j : names.split(",")) {
            namesArrayList.add(j);
        }
        return namesArrayList;
    }

    private ArrayList<String> checkNameLength(ArrayList<String> ListCheck) {
        for (int i = 0; i < ListCheck.size(); i++) {
            if (ListCheck.get(i).length() > 5) {
                String[] str;
                System.out.println("이름 1개당 5글자까지만 됩니다. 다시 해주세요. (이름은 쉼표로 구분하세요)");
                names = sc.nextLine();
                str = names.split(",");
                ArrayList<String> newNames = new ArrayList<>();
                for (String j : str) {
                    newNames.add(j);
                }
                checkNameLength(newNames);
            }
        }
        return ListCheck;
    }

    private void setLadderValue() {
        System.out.println("사다리 층 수는 몇인가요?");
        ladderNum = sc.nextInt();
    }

    public int getLadderNum() {
        return ladderNum;
    }
}
