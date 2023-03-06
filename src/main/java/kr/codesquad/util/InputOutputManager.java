package kr.codesquad.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutputManager {

    OutputHandler outputHandler = new OutputHandler();
    InputHandler inputHandler = new InputHandler();

    void getPeopleAndLadderNum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        outputHandler.outPut("참여할 사람은 몇 명인가요?");
        inputHandler.getInput(br);
        outputHandler.outPut("최대 사다리 높이는 몇 개인가요?");
        inputHandler.getInput(br);
    }

}
