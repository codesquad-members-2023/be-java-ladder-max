package kr.codesquad;

import java.util.ArrayList;
import java.util.HashMap;

public class OutputView {
    public void printInit() {
        System.out.println();
        System.out.println("         사다리 게임을 시작합니다\n");
        System.out.println("+-------------게임 규칙--------------+");
        System.out.println("  1. 이름과 결과는 쉼표(,)로 구분하세요.");
        System.out.println("     ex) 이름 : pobi,honux,crong,jk");
        System.out.println("         결과 : 꽝,5000,꽝,3000");
        System.out.println("  2. 입력은 5글자 이내여야 합니다.");
        System.out.println("  3. 전체 조회 : all");
        System.out.println("  4. 게임 종료 : close");
        System.out.println("+----------------------------------+\n");

    }

    public void printNamesRequest() {
        System.out.println("참여할 사람들의 이름을 입력해주세요.");
    }

    public void printResultsRequest() {
        System.out.println("실행 결과를 입력해주세요.");
    }

    public void printHeightRequest() {
        System.out.println("사다리의 높이를 입력해주세요");
    }

    public void printNameError() {
        System.out.println("이름의 길이가 잘못되었습니다. 다시 입력해주세요.");
    }

    public void printNameNull() {
        System.out.println("입력되지 않은 이름입니다. 다시 입력해주세요.");
    }
    public void printCountMatchError(){
        System.out.println("입력된 이름의 갯수와 결과의 갯수가 다릅니다. 이름의 갯수와 동일하게 입력해주세요.");
    }

    public void printNumberError() {
        System.out.println("올바르지 않은 숫자입니다. 다시 입력해주세요.");
    }

    public void printLadder(ArrayList<Row> list, ArrayList<String> nameList, int height, ArrayList<String> resultList) {
        System.out.println("\n+-------------사다리 결과-------------+\n");
        System.out.println(printNames(nameList));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            sb.append("  ");
            sb.append(getRow(list, nameList.size(), i)).append("\n");
        }
        System.out.print(sb);
        System.out.println(printNames(resultList) + "\n");

    }

    public String printNames(ArrayList<String> nameList) {
        return new Names().getNames(nameList);
    }

    public String getRow(ArrayList<Row> list, int countOfPerson, int index) {
        Row row = list.get(index);
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (int i = 0; i < countOfPerson - 1; i++) {
            String line = (row.getBool(i)) ? "-----" : "     ";
            sb.append(line).append("|");
        }
        return sb.toString();
    }

    public void printPersonRequest() {
        System.out.println("결과를 조회하고 싶은 사람을 입력해주세요.");
    }

    public String printResult(HashMap<String, String> results, String name) {
        System.out.println("\n" + "실행결과");
        if (name.equals("all")) {
            return buildResult(results);
        }
        return results.get(name) + "\n";
    }

    private String buildResult(HashMap<String, String> results) {
        StringBuilder sb = new StringBuilder();
        for (String key : results.keySet()) {
            sb.append(key).append(" : ").append(results.get(key)).append("\n");
        }
        return sb.toString();
    }

    public void printEnd() {
        System.out.println("\n--------------게임 종료---------------");
        System.exit(0);
    }
}
