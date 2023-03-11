package kr.codesquad.domain;

import kr.codesquad.view.Input;
import kr.codesquad.view.Output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LadderGame {
    public void startLadderGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input input = new Input();
        String[] arrayNames;
        boolean check = true;
        while(check) {
            String answer = input.input(br, 0);
            arrayNames = input.splitNames(answer);
            check = input.validateNames(arrayNames);
        }

        Ladder ladder = new Ladder(names.size(), countOfLadder);
        Output output = new Output();
        output.print(names, ladder);
    }
}
