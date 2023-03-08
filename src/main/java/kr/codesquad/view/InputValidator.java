package kr.codesquad.view;

import kr.codesquad.message.ErrorMessage;

public class InputValidator {

    public static void validateHasInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY_ERROR.toString());
        }
    }

    public static void validateSeparatedByDelimiter(String input, String delimiter) {
        if (!input.contains(delimiter)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_DELIMITER.toString());
        }
    }
}
