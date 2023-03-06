package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    public Console() {
    }

    public void askParticipant() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public void askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public int returnInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }
}
