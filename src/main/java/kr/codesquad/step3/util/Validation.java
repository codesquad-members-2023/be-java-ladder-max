package kr.codesquad.step3.util;


public class Validation {

    private static int MIN_LADDER_HEIGHT  = 2;

    public static void validateIsMinHeight(int inputHeight) {
       if(inputHeight < MIN_LADDER_HEIGHT){
           throw new IllegalArgumentException("높이가 너무 적습니다.");
       }
    }
}
