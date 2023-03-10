package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String inputNames() throws IOException {
        String input = br.readLine();
        return input;
    }

    public String inputLadderNumber() throws IOException {
        String input = br.readLine();
        br.close();
        return input;
    }
}
