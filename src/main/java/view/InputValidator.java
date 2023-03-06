package view;

import message.ErrorMessage;

public class InputValidator {

    public static void validateHasInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY_ERROR.toString());
        }
    }
}
