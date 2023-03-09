package kr.codesquad;

import java.io.IOException;

public class LadderGame {
    public static void startLadderGame() throws IOException {
        System.out.println("참여할 사람은 몇 명인가요?");
        int verticalLine = Input.input();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int horizontalLine = Input.input();

        Ladder ladder = new Ladder(verticalLine, horizontalLine);
        Output.printLadder(ladder);
    }
}
