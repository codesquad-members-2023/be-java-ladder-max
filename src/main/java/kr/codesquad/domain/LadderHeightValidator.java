package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.io.IOException;

public class LadderHeightValidator {
    public String getValidHeightFromUser(InputView inputHandler){
        while(true){
            try{
                String height =inputHandler.getInput();
                return validateHeight(height);
            }catch (RuntimeException | IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static String validateHeight(String height) {
        if(Integer.parseInt(height)<1){
            throw new RuntimeException("사다리 높이는 1이상으로 입력");
        }
        return height;
    }
}
