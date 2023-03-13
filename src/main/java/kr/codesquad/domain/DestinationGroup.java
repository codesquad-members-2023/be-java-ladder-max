package kr.codesquad.domain;

import java.util.Arrays;

public class DestinationGroup {

    private final Destination[] destinations;

    public DestinationGroup(String[] destinationNames) {
        validateDestinationsLength();
        destinations = Arrays.stream(destinationNames)
                .map(Destination::new)
                .toArray(Destination[]::new);
    }

    private void validateDestinationsLength(String[] playerNames) {
        if(playerNames.length == 0) {
            throw new IllegalArgumentException("[ERROR] 최소 한명 이상의 플레이어를 입력해 주세요.");
        }
    }

    public String getName(int index) {
        if(index >= destinations.length) {
            return null;
        }
        return destinations[index].getName();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Destination destination : destinations) {
            sb.append(destination.getCenterAlignedName()).append(" ");
        }

        return sb.toString();
    }
}
