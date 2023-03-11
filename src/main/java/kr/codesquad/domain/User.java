package kr.codesquad.domain;

import java.util.Objects;
import kr.codesquad.exception.user.UserNameReservedCommand;
import kr.codesquad.exception.user.UserNameMaxLengthException;
import kr.codesquad.exception.user.UserNameMinLengthException;

public class User {

    public static final int MAX_LENGTH = 5;
    public static final int MIN_LENGTH = 1;

    private final String name;

    public User(String name) {
        String NotBlankName = name.replace(" ", "");
        validateMinLength(NotBlankName);
        validateMaxLength(NotBlankName);
        validateReservedCommand(NotBlankName);
        this.name = NotBlankName;
    }


    private void validateMaxLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new UserNameMaxLengthException();
        }
    }

    private void validateMinLength(String name) {
        if (name.length() < MIN_LENGTH) {
            throw new UserNameMinLengthException();
        }
    }

    private void validateReservedCommand(String name) {
        if (name.equals(LadderGame.END_GAME_COMMAND) ||
            name.equals(LadderGame.PRINT_ALL_RESULT_COMMAND)) {
            throw new UserNameReservedCommand();
        }
    }

    public boolean equals(String name) {
        return this.name.equals(name);
    }

    public String printFormat() {
        int totalLength = MAX_LENGTH + 1;
        int nameLength = this.name.length();
        int leftPadding = ((totalLength - nameLength) / 2) + ((totalLength - nameLength) % 2);
        int rightPadding = (totalLength - nameLength) / 2;
        return String.format("%s%s%s", " ".repeat(leftPadding), this.name, " ".repeat(rightPadding));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
