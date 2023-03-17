package kr.codesquad.step1_step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Input {

    public int value() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        return  Integer.parseInt(bufferedReader.readLine());
    }

}
