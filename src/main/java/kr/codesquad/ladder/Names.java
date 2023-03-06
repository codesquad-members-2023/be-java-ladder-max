package kr.codesquad.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names createNames(String[] names) {
        return new Names(Arrays.stream(names)
                .map(Name::new)
                .collect(Collectors.toUnmodifiableList()));
    }

    @Override
    public String toString() {
        return names.stream()
                .map(name -> name.toString())
                .collect(Collectors.joining());
    }
}
