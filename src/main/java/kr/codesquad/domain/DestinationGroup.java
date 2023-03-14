package kr.codesquad.domain;

import java.util.Arrays;

public class DestinationGroup {

    private final Destination[] destinations;

    public DestinationGroup(String[] destinationNames, int count) {
        validateDestinationsLength(destinationNames, count);
        destinations = Arrays.stream(destinationNames)
                .map(Destination::new)
                .toArray(Destination[]::new);
    }

    private void validateDestinationsLength(String[] destinationNames, int count) {
        if(destinationNames.length != count) {
            throw new IllegalArgumentException("[ERROR] " + count + "명의 결과를 입력해 주세요.");
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
