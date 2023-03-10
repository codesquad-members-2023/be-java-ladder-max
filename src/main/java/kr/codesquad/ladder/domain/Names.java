package kr.codesquad.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Names {

    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names createNames(List<String> names) {
        return new Names(names.stream()
                .map(Name::new)
                .collect(Collectors.toUnmodifiableList()));
    }

    public int getIndex(String name) {
        return IntStream.range(0, names.size())
                .filter(index -> names.get(index).isSame(name))
                .findFirst()
                .orElseThrow();
    }

    public String getName(int index) {
        return names.get(index).getName();
    }

    public int getSize() {
        return names.size();
    }

    @Override
    public String toString() {
        return names.stream()
                .map(name -> name.toString())
                .collect(Collectors.joining());
    }
}
