package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String inputNames() throws IOException {
        String input = br.readLine();
        return input;
    }

    public static String inputLadderNumber() throws IOException {
        String input = br.readLine();
        br.close();
        return input;
    }
}
