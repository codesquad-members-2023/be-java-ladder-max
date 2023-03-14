package kr.codesquad.ladder.domain;

import java.util.regex.Pattern;

public class Name {

    private static final Pattern NAME_FORMAT = Pattern.compile("[a-zA-Z]{1,5}");

    private final String name;

    public Name(String name) {
        validateNameFormat(name);
        this.name = name;
    }

    private void validateNameFormat(String name) {
        if (!NAME_FORMAT.pattern().matches(name)) {
            throw new InvalidNameFormatOfPeopleException();
        }
    }
}
