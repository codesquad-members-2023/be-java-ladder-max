package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Names {

    private static final Pattern NAME_FORMAT = Pattern.compile("[a-zA-Z]{1,5}");
    private static final Pattern DELIMITER = Pattern.compile("\\s*,\\s*");

    private final List<String> names;

    public Names(String text, int minimumNumberOfPeople) {
        validateNameFormat(text);
        validateNumberOfPeople(text, minimumNumberOfPeople);
        this.names = new ArrayList<>(List.of(text.split(DELIMITER.pattern())));
    }

    // text 형식이 "pobi,hounx,jk, ..., crong"와 같은 형식인지 검사합니다.
    private void validateNameFormat(String text) {
        String[] names = text.split(DELIMITER.pattern());
        Arrays.stream(names)
            .filter(name -> !NAME_FORMAT.matcher(name).matches())
            .forEach(name -> {
                throw new InvalidNameFormatOfPeopleException();
            });
    }

    private void validateNumberOfPeople(String text, int minimumNumberOfPeople) {
        String[] names = text.split(DELIMITER.pattern());
        if (names.length < minimumNumberOfPeople) {
            throw new InvalidCountOfPeopleException();
        }
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
