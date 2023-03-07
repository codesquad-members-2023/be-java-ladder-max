package kr.codesquad.domain;

import kr.codesquad.message.ErrorMessage;
import kr.codesquad.view.InputValidator;

public class Player {

    public static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        InputValidator.validateHasInput(name);
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.toString());
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
