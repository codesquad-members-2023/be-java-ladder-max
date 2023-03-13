package kr.codesquad.domain;

import java.util.Arrays;

public class DestinationGroup {

    private final Destination[] destinations;

    public DestinationGroup(String[] destinationNames) {
        destinations = Arrays.stream(destinationNames)
                .map(Destination::new)
                .toArray(Destination[]::new);
    }
}
