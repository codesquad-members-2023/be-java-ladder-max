package kr.codesquad;

import java.util.Scanner;
import java.util.ArrayList;

public class Inputer {
    Scanner sc = new Scanner(System.in);
    private String names;
    private int ladderNum;

    public ArrayList<String> seting() {
        setManValue();
        ArrayList<String> temp = check();
        setLadderValue();
        return temp;
    }

    private void setManValue() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표로 구분하세요)");
    }

    ArrayList<String> check() {
        ArrayList<String> arrayList = new ArrayList<>();
        names = sc.nextLine();
        String[] str = names.split(",");
        for (int i = 0; i < str.length; i++) {
            arrayList.add(str[i]);
            if (str[i].length() > 5) {
                System.out.println("이름 1개당 5글자까지만 됩니다. 다시 해주세요. (이름은 쉼표로 구분하세요)");
                str = null;
                arrayList = null;
                check();
            }
        }
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
