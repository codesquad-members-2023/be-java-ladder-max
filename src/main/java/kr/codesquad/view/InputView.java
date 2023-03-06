package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int inputPlayerCount() throws IOException, NumberFormatException {
        System.out.println("참여할 사람은 몇 명인가요?");
        return Integer.parseInt(br.readLine());
    }

    public int inputLadderHeight() throws IOException, NumberFormatException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(br.readLine());
    }
}
