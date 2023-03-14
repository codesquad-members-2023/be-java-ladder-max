package kr.codesquad.view;

import java.util.Map;

public class Output {

    public void printLadder(String ladder, String names, String results) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n사다리 출력\n");
        sb.append(names);
        sb.append(ladder);
        sb.append(results);

        System.out.println(sb);
    }

    public void printPlayerResult(String result) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n실행 결과\n");
        sb.append(result + "\n");
        System.out.println(sb);
    }

    public void printAllResult(Map<String, String> nameResultPair) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n실행 결과\n");
        for (String name : nameResultPair.keySet()) {
            sb.append(name + " : " + nameResultPair.get(name) + "\n");
        }
        System.out.println(sb);
    }

}
