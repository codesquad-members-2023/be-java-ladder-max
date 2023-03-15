package kr.codesquad.util;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Validation {

    private static final int maxLength = 5;
    private static final int minLimit = 0;

    public static boolean checkValidName(Optional<List<String>> opPeople) {
        if(opPeople.isEmpty()) {
            return false;
        }
        List<String> people = opPeople.get();
        Set<String> peopleSet = new HashSet<>(people);
        if(peopleSet.size() != people.size() || peopleSet.contains("춘식이")) {
            System.out.println("중복된 이름이 들어가거나 \"춘식이\"란 이름은 사용하실 수 없습니다.");
            return false;
        }
        return true;
    }

    public static boolean checkValidNumber(Optional<String> opInput) {
        if(opInput.isEmpty()) {
            return false;
        }
        try {
            int num = Integer.parseInt(opInput.get());
            return checkLimit(num);
        } catch (NumberFormatException e) {
            System.out.println("올바른 int 숫자 형식이 아닙니다.");
            return false;
        }
    }

    public static boolean checkValidResults(Optional<List<String>> opResults, int len) {
        if(opResults.isEmpty()) {
            return false;
        }
        List<String> results = opResults.get();
        if(results.size() != len) {
            System.out.println("결과의 길이가 참여한 사람들의 길이와 다릅니다.");
            return false;
        }
        return true;
    }

    public static boolean checkLimit(int num) {
        if(num < minLimit) {
            System.out.println("입력되는 숫자는 0보다 작을 수 없습니다.");
            return false;
        }
        return true;
    }

    public static boolean isAnyOverFive(List<String> people) {
        return people.stream()
                .anyMatch(o -> o.length() > maxLength);
    }
}
