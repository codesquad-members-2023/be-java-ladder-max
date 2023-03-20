package kr.codesquad.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Validator {

    private static final String NAME_LENGTH_ERROR_MESSAGE = "이름은 5글자 이하여야 합니다. 다시 입력해주세요.";
    private static final String PLAYER_NUMBER_ERROR_MESSAGE = "player는 2명 이상이 필요합니다. 다시 입력해주세요.";
    private final String ERROR_MESSAGE_FOR_LADDER_HEIGHT = "사다리 높이는 2이상으로 입력";
    private static final String ERROR_MESSAGE_FOR_CONSECUTIVE_POINTS = "연속적인 true 존재";

    public List<String> getValidPlayerFromUser(String players) {
        try {
            List<String> tempList = parseInputStringToValidNames(players);
            validatePlayerNumAndThrowException(tempList);
            return tempList;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private List<String> parseInputStringToValidNames(String inputString) {
        return Arrays.stream(inputString.split(","))
                .map(this::validateNameAndThrowException)
                .collect(Collectors.toList());
    }

    private String validateNameAndThrowException(String name) {
        if (name.length() > 5) {
            throw new RuntimeException(NAME_LENGTH_ERROR_MESSAGE);
        }
        return name;
    }

    private void validatePlayerNumAndThrowException(List playersList) {
        if (playersList.size() < 2) {
            throw new RuntimeException(PLAYER_NUMBER_ERROR_MESSAGE);
        }
    }

    public boolean getValidHeightFromUser(int ladderHeight) {
        try {
            validateHeightAndThrowException(ladderHeight);
            return true;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private void validateHeightAndThrowException(int height) {
        if (height < 2) {
            throw new RuntimeException(ERROR_MESSAGE_FOR_LADDER_HEIGHT);
        }
    }

    public List getResultsFromUser(String strResults, int sizeOfNameList){
        try {
            List<String> tempResult = parseInputStringToResultList(strResults);
            validateNumOfResultList(tempResult,sizeOfNameList);
            return tempResult;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private List<String> parseInputStringToResultList(String strContainsName) {
        return Arrays.stream(strContainsName.split(","))
                .collect(Collectors.toList());
    }

    private void validateNumOfResultList(List list, int sizeOfNameList) {
        if (list.size() != sizeOfNameList) {
            throw new RuntimeException("실행결과 갯수와 player갯수가 다릅니다");
        }
    }

    boolean validatePoints(ArrayList<Boolean> points) {
        try {
            validatePointsAndThrowException(points);
            return true;
        }catch (IllegalStateException e){
            System.out.println(e);
        }
        return false;
    }

    private void validatePointsAndThrowException(ArrayList<Boolean> points){
        IntStream.range(0, points.size()-1)
                .filter(i ->points.get(i) && points.get(i + 1))
                .findFirst()
                .ifPresent(i -> {
                    throw new IllegalStateException(ERROR_MESSAGE_FOR_CONSECUTIVE_POINTS);
                });
    }

}
