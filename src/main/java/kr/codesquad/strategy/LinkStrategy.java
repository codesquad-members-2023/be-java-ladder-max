package kr.codesquad.strategy;

import kr.codesquad.domain.Direction;

import java.util.List;

// Strategy(전략)
public interface LinkStrategy {
    List<Direction> link(final int ladderHeight);
}
