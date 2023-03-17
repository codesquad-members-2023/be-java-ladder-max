package kr.codesquad.ladder.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import kr.codesquad.ladder.exception.InvalidCountOfDestinationsException;

public class Destinations implements Iterable<Destination> {

    private final List<Destination> destinations;

    public Destinations(List<Destination> destinations, int countOfPeople) {
        validateCountOfDestinations(destinations, countOfPeople);
        this.destinations = destinations;
    }

    private void validateCountOfDestinations(List<Destination> ladderResults, int countOfPeople) {
        if (ladderResults.size() != countOfPeople) {
            throw new InvalidCountOfDestinationsException(countOfPeople);
        }
    }

    public Destination get(int index) {
        return destinations.get(index);
    }

    @Override
    public Iterator<Destination> iterator() {
        return destinations.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Destinations)) {
            return false;
        }
        Destinations that = (Destinations) o;
        return Objects.equals(destinations, that.destinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinations);
    }

    @Override
    public String toString() {
        return destinations.stream()
            .map(ladderResult -> String.format("%-5s", ladderResult.toString()))
            .collect(Collectors.joining());
    }


}
