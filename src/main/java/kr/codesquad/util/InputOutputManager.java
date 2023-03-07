package kr.codesquad.util;

import kr.codesquad.Ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputOutputManager {

    OutputHandler outputHandler = new OutputHandler();
    InputHandler inputHandler = new InputHandler();

    final String[] promptMessages = {"참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)",
            "최대 사다리 높이는 몇 개인가요?"};

    public ArrayList getInputFromUser() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrForHeightAndWidth = new ArrayList<>();
        for (String prompt : promptMessages) {
            outputHandler.outPut(prompt);
            arrForHeightAndWidth.add(Integer.parseInt(inputHandler.getInput(br)));
        }
        return arrForHeightAndWidth;
    }

    public void printLadder(Ladder ladder){
        outputHandler.printLadder(ladder);
    }
}
