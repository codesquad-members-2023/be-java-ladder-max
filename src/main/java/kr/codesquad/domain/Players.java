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

    private final ArrayList<String> nameList;

    public Players() {
        this.nameList = new ArrayList<>();
    }

    public ArrayList<String> getNameList() {
        return nameList;
    }

    String getNameFromNameList(int i){
        return nameList.get(i);
    }

    public boolean getVaildNameFromUser(InputView inputView) {
        try {
            String inputString = inputView.getInput();
            nameList.addAll(parseInputStringToValidNames(inputString));
            validatePlayerNumAndThrowException();
            return true;
        } catch (RuntimeException | IOException e) {
            nameList.clear();
            System.out.println(e.getMessage());
            return false;
        }
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
        if (nameList.size() < 2) {
            throw new RuntimeException(PLAYER_NUMBER_ERROR_MESSAGE);
        }
    }

    private void drawName(StringBuilder sb) {
        for (String name : nameList) {
            sb.append(String.format(" %1$-5s", name));
        }
        sb.append("\n");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        drawName(sb);
        return sb.toString();
    }
}