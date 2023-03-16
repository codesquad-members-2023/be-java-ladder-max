package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import kr.codesquad.ladder.exception.InvalidContainOfNamesException;
import kr.codesquad.ladder.exception.InvalidCountOfPeopleException;

public class Names implements Iterable<Name> {

    private static final int MINIMUM_PERSON = 2;

    private final List<Name> names;

    public Names(List<Name> names) {
        validateNumberOfPeople(names);
        this.names = new ArrayList<>(names);
    }

    private void validateNumberOfPeople(List<Name> names) {
        if (names.size() < MINIMUM_PERSON) {
            throw new InvalidCountOfPeopleException();
        }
    }

    public int size() {
        return names.size();
    }

    public int findIndexByName(Name name) {
        if (isNotContains(name)) {
            throw new InvalidContainOfNamesException();
        }
        return names.indexOf(name);
    }

    private boolean isNotContains(Name name) {
        return names.indexOf(name) == -1;
    }

    @Override
    public Iterator<Name> iterator() {
        return names.iterator();
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
