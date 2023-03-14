package kr.codesquad.strategy;

import kr.codesquad.domain.Direction;

import java.util.List;
import java.util.Random;

public class RandomLinkStrategy implements LinkStrategy {
    private static final Random random = new Random();

    @Override
    public List<Direction> link(int ladderHeight) {
        return null;
    }
}
