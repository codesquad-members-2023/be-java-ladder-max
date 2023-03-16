package kr.codesquad.ladder.domain;

import java.util.Objects;
import kr.codesquad.ladder.exception.InvalidFormatOfDestinationException;

public class Destination {

    private static final int LENGTH_LIMIT = 5;

    private final String value;

    public Destination(String value) {
        validateLengthOfLadderResult(value);
        this.value = value;
    }

    public void validateLengthOfLadderResult(String value) {
        if (value.length() > LENGTH_LIMIT) {
            throw new InvalidFormatOfDestinationException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Destination)) {
            return false;
        }
        Destination that = (Destination) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
