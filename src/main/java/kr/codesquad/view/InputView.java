package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private String PLAYER_NAME_MESSAGE="참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private String RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private String EXECUTION_SELECT_PLAYER ="결과를 보고 싶은 사람은?";
    private String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public void playerNamePrompt(){
        System.out.println(PLAYER_NAME_MESSAGE);
    }
    public void LadderHeightPrompt(){
        System.out.println(LADDER_HEIGHT_MESSAGE);
    }
    public void resultPrompt(){
        System.out.println(RESULT_MESSAGE);
    }
    public void selectPlayerPrompt(){
        System.out.println("\n"+EXECUTION_SELECT_PLAYER);
    }
    public void executionResultPrompt(){
        System.out.println("\n"+EXECUTION_RESULT_MESSAGE);
    }

    public String getInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
