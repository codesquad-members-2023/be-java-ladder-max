package kr.codesquad.ladder.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import kr.codesquad.ladder.domain.Destination;
import kr.codesquad.ladder.domain.Destinations;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.LadderGenerator;
import kr.codesquad.ladder.domain.LadderResult;
import kr.codesquad.ladder.domain.LadderResults;
import kr.codesquad.ladder.domain.Name;
import kr.codesquad.ladder.domain.Names;
import kr.codesquad.ladder.exception.InvalidContainOfNamesException;
import kr.codesquad.ladder.exception.InvalidCountOfLadderResultException;
import kr.codesquad.ladder.exception.InvalidCountOfPeopleException;
import kr.codesquad.ladder.exception.InvalidFormatOfDestinationException;
import kr.codesquad.ladder.exception.InvalidNameFormatOfPeopleException;
import kr.codesquad.ladder.exception.InvalidNumberOfMinimumLadderHeightException;
import kr.codesquad.ladder.view.LadderReader;
import kr.codesquad.ladder.view.LadderWriter;

public class LadderConsoleReaderController {

    private static final String ALL = "all";
    private static final String EXIT = "춘식이";

    private final LadderReader ladderReader;
    private final LadderWriter ladderWriter;

    public LadderConsoleReaderController(LadderReader ladderReader, LadderWriter ladderWriter) {
        this.ladderReader = ladderReader;
        this.ladderWriter = ladderWriter;
    }

    public Names getNamesOfPeoples() {
        Optional<Names> optionalNames = Optional.empty();
        while (optionalNames.isEmpty()) {
            String[] nameArray = ladderReader.readNamesOfPeoples();
            optionalNames = getNamesInstance(nameArray);
        }
        return optionalNames.get();
    }

    private Optional<Names> getNamesInstance(String[] nameArray) {
        Optional<Names> optionalNames = Optional.empty();
        try {
            List<Name> nameList = createNameOfPeopleListInstance(nameArray);
            optionalNames = Optional.of(new Names(nameList));
        } catch (InvalidNameFormatOfPeopleException | InvalidCountOfPeopleException e) {
            ladderWriter.write(e.getMessage());
        }
        return optionalNames;
    }

    private List<Name> createNameOfPeopleListInstance(String[] nameArray) {
        List<Name> nameList = new ArrayList<>();
        for (String name : nameArray) {
            nameList.add(new Name(name));
        }
        return nameList;
    }

    public Destinations getDestinations(int countOfPeople) {
        Optional<Destinations> optionalDestinations = Optional.empty();
        while (optionalDestinations.isEmpty()) {
            String[] dstArray = ladderReader.readDestinations();
            optionalDestinations = getDestinationsInstance(dstArray, countOfPeople);
        }
        return optionalDestinations.get();
    }

    private Optional<Destinations> getDestinationsInstance(String[] dstArray, int countOfPeople) {
        Optional<Destinations> optionalDestinations = Optional.empty();
        try {
            List<Destination> dstList = createDestinationList(dstArray);
            optionalDestinations = Optional.of(new Destinations(dstList, countOfPeople));
        } catch (InvalidCountOfLadderResultException | InvalidFormatOfDestinationException e) {
            ladderWriter.write(e.getMessage());
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

    public LadderGenerator getLadderGenerator() {
        Optional<LadderGenerator> optionalLadderGenerator = Optional.empty();
        while (optionalLadderGenerator.isEmpty()) {
            int maximumLadderHeight = ladderReader.readMaximumLadderHeight();
            optionalLadderGenerator = getLadderGeneratorInstance(maximumLadderHeight);
        }
        return optionalLadderGenerator.get();
    }

    private Optional<LadderGenerator> getLadderGeneratorInstance(int maximumLadderHeight) {
        Optional<LadderGenerator> optionalLadderGenerator = Optional.empty();
        try {
            optionalLadderGenerator = Optional.of(new LadderGenerator(maximumLadderHeight));
        } catch (InvalidNumberOfMinimumLadderHeightException e) {
            ladderWriter.write(e.getMessage());
        }
        return optionalLadderGenerator;
    }

    public void startReadNameOfPeopleForLadderResult(Names names, Ladder ladder,
        Destinations destinations) {
        while (true) {
            String nameText = ladderReader.readNameOfPeopleForLadderResult(names);
            if (nameText.equals(EXIT)) {
                break;
            }
            if (nameText.equals(ALL)) {
                LadderResults allLadderResult = getAllLadderResult(names, ladder, destinations);
                ladderWriter.writeLadderResults(allLadderResult);
                continue;
            }

            try {
                Name name = new Name(nameText);
                LadderResult ladderResult = getLadderResult(name, names, ladder, destinations);
                ladderWriter.writeLadderResult(ladderResult);
            } catch (InvalidNameFormatOfPeopleException | InvalidContainOfNamesException e) {
                ladderWriter.write(e.getMessage());
            }
        }
    }

    private LadderResults getAllLadderResult(Names names, Ladder ladder,
        Destinations destinations) {
        List<LadderResult> ladderResultList = new ArrayList<>();
        for (Name name : names) {
            int columnByName = names.findIndexByName(name);
            int dstIndex = ladder.climb(columnByName);
            Destination destination = destinations.get(dstIndex);
            ladderResultList.add(new LadderResult(name, destination));
        }
        return new LadderResults(ladderResultList);
    }

    private LadderResult getLadderResult(Name name, Names names, Ladder ladder,
        Destinations destinations) {

        int columnByName = names.findIndexByName(name);
        int dstIndex = ladder.climb(columnByName);
        Destination destination = destinations.get(dstIndex);
        return new LadderResult(name, destination);
    }
}
