package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.io.IOException;
import java.util.ArrayList;

public class LadderHeightValidator {
    public boolean getValidHeightFromUser(ArrayList list,InputView inputHandler){
            try{
                String height =inputHandler.getInput();
                list.add(validateHeight(height));
                return true;
            }catch (RuntimeException | IOException e){
                System.out.println(e.getMessage());
            }
            return false;
    }

    private static String validateHeight(String height) {
        if(Integer.parseInt(height)<1){
            throw new RuntimeException("사다리 높이는 1이상으로 입력");
        }
        return height;
    }
}
