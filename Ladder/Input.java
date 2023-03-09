package Ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    public static void takeInput() throws IOException {
        System.out.println("참여할 사람은 몇 명인가요?");
        int pplNumber = takeInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = takeInt();
        createLadder(pplNumber, ladderHeight);
    }

    private static void createLadder(int pplNumber, int ladderHeight) {
        Ladder ladder = new Ladder(pplNumber, ladderHeight);
    }

    private static int takeInt() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }
}
