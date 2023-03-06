package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int inputPlayerCount() throws IOException, NumberFormatException {
        return Integer.parseInt(br.readLine());
    }

    public int inputLadderHeight() throws IOException, NumberFormatException {
        return Integer.parseInt(br.readLine());
    }
}
