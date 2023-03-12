package kr.codesquad.step3.domain;

import java.util.Objects;

import kr.codesquad.step3.util.Validation;

public class Participate {
    private final String name;

    public Participate(String name) {
        Validation.validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participate that = (Participate) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
