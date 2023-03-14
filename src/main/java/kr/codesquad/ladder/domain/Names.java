package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Names {

    private static final int MINIMUM_PERSON = 2;

    private final List<Name> names;

    public Names(String[] names) {
        validateNumberOfPeople(names);
        this.names = toList(names);
    }

    private void validateNumberOfPeople(String[] names) {
        if (names.length < MINIMUM_PERSON) {
            throw new InvalidCountOfPeopleException();
        }
    }

    private List<Name> toList(String[] names) {
        List<Name> nameList = new ArrayList<>();
        for (String name : names) {
            nameList.add(new Name(name));
        }
        return nameList;
    }

    public int size() {
        return names.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Names)) {
            return false;
        }
        Names names = (Names) o;
        return Objects.equals(this.names, names.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

    @Override
    public String toString() {
        return names.stream()
            .map(name -> String.format("%-5s", name))
            .collect(Collectors.joining(" "));
    }
}
