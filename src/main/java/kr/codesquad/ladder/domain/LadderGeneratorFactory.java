package kr.codesquad.ladder.domain;

public class LadderGeneratorFactory {

    public LadderGenerator create(int maximumLadderHeight) {
        return new LadderGenerator(maximumLadderHeight);
    }
}
