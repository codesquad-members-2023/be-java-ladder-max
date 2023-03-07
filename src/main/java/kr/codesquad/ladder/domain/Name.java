package kr.codesquad.ladder.domain;

import java.util.Objects;

public class Name {

    private final String NAME_LENGTH_EXCEPTION_MESSAGE = "이름은 5글자를 넘을 수 없습니다.";
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = String.format("%-6s", name);
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
