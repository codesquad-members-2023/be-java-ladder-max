package kr.codesquad.ladder.domain;

import java.util.Objects;
import java.util.regex.Pattern;
import kr.codesquad.ladder.exception.InvalidNameFormatOfPeopleException;

public class Name {

    private static final Pattern NAME_FORMAT = Pattern.compile("[a-zA-Z]{1,5}");

    private final String name;

    public Name(String name) {
        validateNameFormat(name);
        this.name = name;
    }

    private void validateNameFormat(String name) {
        if (!NAME_FORMAT.matcher(name).matches()) {
            throw new InvalidNameFormatOfPeopleException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Name)) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("%-5s", name);
    }
}
