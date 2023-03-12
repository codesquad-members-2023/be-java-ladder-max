package kr.codesquad.step3.util;

public class Util {
    public static final String REGEX = ",";

    public static String[] splitParticipateName(String inputParticipateNames){
        return inputParticipateNames.split(REGEX);
    }
}
