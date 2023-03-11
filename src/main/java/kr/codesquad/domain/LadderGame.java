package kr.codesquad.domain;

import kr.codesquad.view.Input;
import kr.codesquad.view.Output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGame {
    public void startLadderGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input input = new Input();
        ArrayList<String> names;
        while(true) {
            String answer = input.input(br, 0);
            String[] arrayNames = input.splitNames(answer);
            if(input.validateNames(arrayNames)) {
                names = new ArrayList<>(Arrays.asList(arrayNames));
                break;
            }
        }

        Ladder ladder = new Ladder(names.size(), countOfLadder);
        Output output = new Output();
        output.print(names, ladder);
    }
}
