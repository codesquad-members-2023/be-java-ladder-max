package kr.codesquad;

import static kr.codesquad.Ladder.*;

public class Output {
    public void printPeopleRequest() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public void printHeightRequest() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printLadder() {
        System.out.print("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(getRow(i)).append("\n");
        }
        System.out.print(sb);
    }

    public String getRow(int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < m * 2 - 1; j++) {
            sb.append(ladder[i][j]);
        }
        return sb.toString();
    }
}
