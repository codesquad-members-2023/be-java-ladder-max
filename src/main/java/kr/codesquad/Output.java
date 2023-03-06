package kr.codesquad;

import static kr.codesquad.Ladder.m;
import static kr.codesquad.Ladder.n;

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
            for (int j = 0; j < m * 2 + 1; j++) {
                sb.append(Ladder.ladder[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
