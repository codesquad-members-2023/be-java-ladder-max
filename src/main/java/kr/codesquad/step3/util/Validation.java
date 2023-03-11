package kr.codesquad.step3.util;

import java.util.List;

public class Validation {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_LADDER_HEIGHT  = 2;
    public static final int MIN_PLAYER = 2;

    public static void validateIsMinHeight(int inputHeight) {
       if(inputHeight < MIN_LADDER_HEIGHT){
           throw new IllegalArgumentException("높이가 너무 적습니다.");
       }
    }

    public static void validateName(String name){
        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("이름은 5자를 넘을 수 없습니다.");
        }
    }

    public static void validateMinimumParticipates(List<String> participates){
        if(participates.size()<MIN_PLAYER){
            throw new IllegalArgumentException("참가자가 적습니다.");
        }
    }

    public static void validateInputNames(String inputParticipateNames){
        if(isEmptyOrBlank(inputParticipateNames)){
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
        }
    }

    private static boolean isEmptyOrBlank(String input){
        return isEmpty(input) || isBlank(input);
    }

    public static boolean isEmpty(String input) {
        return "".equals(input);
    }

    public static boolean isBlank(String input) {
        return input == null;
    }

}
