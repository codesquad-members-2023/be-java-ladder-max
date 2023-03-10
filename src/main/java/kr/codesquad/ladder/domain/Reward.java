package kr.codesquad.ladder.domain;

import java.util.Objects;

public class Reward {

    private static final String REWARD_LENGTH_EXCEPTION_MESSAGE = "결과는 5글자를 넘을 수 없습니다.";
    private final String value;

    public Reward(String value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(String value) {
        if (value.length() > 5) {
            throw new IllegalArgumentException(REWARD_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public boolean isSame(String name) {
        return this.value.equals(name);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%-6s", value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reward reward = (Reward) o;
        return Objects.equals(value, reward.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
