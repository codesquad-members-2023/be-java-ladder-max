package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import kr.codesquad.ladder.exception.InvalidCountOfLadderResultException;
import kr.codesquad.ladder.exception.InvalidFormatOfDestinationException;

public class DestinationsFactory {

    public Optional<Destinations> getDestinationsInstance(String[] dstArray, int countOfPeople) {
        Optional<Destinations> optionalDestinations = Optional.empty();
        try {
            List<Destination> dstList = createDestinationList(dstArray);
            optionalDestinations = Optional.of(new Destinations(dstList, countOfPeople));
        } catch (InvalidCountOfLadderResultException | InvalidFormatOfDestinationException e) {
//            ladderWriter.write(e.getMessage());
        }
        return optionalDestinations;
    }

    private List<Destination> createDestinationList(String[] dstArray) {
        List<Destination> dstList = new ArrayList<>();
        for (String dst : dstArray) {
            dstList.add(new Destination(dst));
        }
        return dstList;
    }
}
