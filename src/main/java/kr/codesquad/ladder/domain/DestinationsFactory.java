package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class DestinationsFactory {

    public Destinations createDestinations(String[] dstArray, int countOfPeople) {
        List<Destination> dstList = createDestinationList(dstArray);
        return new Destinations(dstList, countOfPeople);
    }

    private List<Destination> createDestinationList(String[] dstArray) {
        List<Destination> dstList = new ArrayList<>();
        for (String dst : dstArray) {
            dstList.add(new Destination(dst));
        }
        return dstList;
    }
}
