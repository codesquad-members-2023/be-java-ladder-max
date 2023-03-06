package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String inputN() throws IOException {
        String input = br.readLine();
        return input;
    }

    public String inputM() throws IOException {
        String input = br.readLine();
        br.close();
        return input;
    }
}
