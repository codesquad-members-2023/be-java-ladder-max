package kr.codesquad.domain;

public class Validator {
    public static String validateName(String inputData) {
        if(!inputData.matches(".+,.+")){
            throw new RuntimeException("참여할 사람은 2명 이상 이어야 합니다.");
        }
        return inputData;
    }

    public static int validateHeight(int height) {
        if(height < 0){
            throw new RuntimeException("사다리의 높이는 1이상 이어야 합니다.");
        }
        return height;
    }
}
