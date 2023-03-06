package kr.codesquad.ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private final String NAME_SEPARATOR = ",";
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String[] inputNames() throws IOException {
        return bufferedReader.readLine().split(NAME_SEPARATOR);
    }

    public int inputHeight() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

}
