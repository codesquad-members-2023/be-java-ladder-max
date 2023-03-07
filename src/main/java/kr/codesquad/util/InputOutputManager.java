package kr.codesquad.util;

import kr.codesquad.Ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutputManager {

    OutputHandler outputHandler = new OutputHandler();
    InputHandler inputHandler = new InputHandler();

    public InputOutputManager(Ladder ladder) throws IOException {
        getInput(ladder);
    }

    void getInput(Ladder ladder) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        outputHandler.outPut("참여할 사람은 몇 명인가요?");
        ladder.setPeopleNum(Integer.parseInt(inputHandler.getInput(br)));
        outputHandler.outPut("최대 사다리 높이는 몇 개인가요?");
        ladder.setLadderHeight(Integer.parseInt(inputHandler.getInput(br)));
    }

    public void printLadder(Ladder ladder){
        outputHandler.printLadder(ladder);
    }
}
