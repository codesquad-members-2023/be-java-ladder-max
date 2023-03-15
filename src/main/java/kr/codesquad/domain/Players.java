package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final String NAME_LENGTH_ERROR_MESSAGE = "이름은 5글자 이하여야 합니다. 다시 입력해주세요.";
    private static final String PLAYER_NUMBER_ERROR_MESSAGE = "player는 2명 이상이 필요합니다. 다시 입력해주세요.";

    private  ArrayList<String> playersList;

    public Players() {
        playersList = new ArrayList<>();
    }

    public ArrayList<String> getPlayersList() {
        return playersList;
    }

    String getNameFromNameList(int i){
        return playersList.get(i);
    }

    public boolean getValidPlayerFromUser(String players) {
        try {
            playersList.addAll(parseInputStringToValidNames(players));
            validatePlayerNumAndThrowException();
            return true;
        } catch (RuntimeException e) {
            playersList.clear();
            System.out.println(e.getMessage());
        }
        return false;
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

    private void validatePlayerNumAndThrowException() {
        if (playersList.size() < 2) {
            throw new RuntimeException(PLAYER_NUMBER_ERROR_MESSAGE);
        }
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String name : playersList) {
            sb.append(String.format(" %1$-5s", name));
        }
        sb.append("\n");
        return sb.toString();
    }
}