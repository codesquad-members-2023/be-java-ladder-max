package kr.codesquad;

import java.util.ArrayList;

public class OutputView {
    public void printNamesRequest() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void printHeightRequest() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printNameError() {
        System.out.println("이름의 길이가 잘못되었습니다. 다시 입력하세요.");
    }

    public void printNumberError() {
        System.out.println("올바르지 않은 숫자입니다. 다시 입력하세요.");
    }

    public void printLadder(ArrayList<String> nameList, int height) {
        System.out.println("\n" + "실행결과" + "\n");
        System.out.println(printNames(nameList));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            sb.append("  ");
            sb.append(getRow(nameList.size(), i)).append("\n");
        }
        System.out.print(sb);
    }

    public String printNames(ArrayList<String> nameList) {
        return new Names().getNames(nameList);
    }

    public String getRow(int countOfPerson, int index) {
        Row row = Ladder.list.get(index);
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (int i = 0; i < countOfPerson - 1; i++) {
            String line = (row.getBool(i)) ? "-----" : "     ";
            sb.append(line).append("|");
        }
        return sb.toString();
    }
}
