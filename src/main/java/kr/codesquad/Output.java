package kr.codesquad;

import java.util.ArrayList;

import static kr.codesquad.Ladder.*;

public class Output {
    public void printNamesRequest() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void printHeightRequest() {
        System.out.println("\n" + "최대 사다리 높이는 몇 개인가요?");
    }


    public void printLadder(ArrayList<String> nameList) {
        System.out.println("\n" + "실행결과" + "\n");
        System.out.println(printNames(nameList));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("  ");
            sb.append(getRow(i)).append("\n");
        }
        System.out.print(sb);
    }

    public String printNames(ArrayList<String> nameList) {
        return new Names().getNames(nameList);
    }

    public String getRow(int i) {
        ArrayList<String> row = ladder.get(i);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < row.size(); j++) {
            sb.append(row.get(j));
        }
        return sb.toString();
    }
}
