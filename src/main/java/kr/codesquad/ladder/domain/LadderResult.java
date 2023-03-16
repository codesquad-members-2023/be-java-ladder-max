package kr.codesquad.ladder.domain;

public class LadderResult {

    private final Name name;
    private final Destination destination;

    public LadderResult(Name name, Destination destination) {
        this.name = name;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, destination);
    }
}
