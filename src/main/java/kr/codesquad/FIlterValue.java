package kr.codesquad;

import java.util.Optional;

@FunctionalInterface
public interface FIlterValue {
    <T> Optional<T> filter();
}
