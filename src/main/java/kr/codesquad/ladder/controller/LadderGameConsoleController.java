package kr.codesquad.ladder.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import kr.codesquad.ladder.domain.Destination;
import kr.codesquad.ladder.domain.Destinations;
import kr.codesquad.ladder.domain.DestinationsFactory;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.LadderGenerator;
import kr.codesquad.ladder.domain.LadderGeneratorFactory;
import kr.codesquad.ladder.domain.LadderResult;
import kr.codesquad.ladder.domain.LadderResults;
import kr.codesquad.ladder.domain.Name;
import kr.codesquad.ladder.domain.Names;
import kr.codesquad.ladder.domain.NamesFactory;
import kr.codesquad.ladder.exception.InvalidContainOfNamesException;
import kr.codesquad.ladder.exception.InvalidCountOfDestinationsException;
import kr.codesquad.ladder.exception.InvalidCountOfPeopleException;
import kr.codesquad.ladder.exception.InvalidFormatOfDestinationException;
import kr.codesquad.ladder.exception.InvalidNameFormatOfPeopleException;
import kr.codesquad.ladder.exception.InvalidNumberOfMinimumLadderHeightException;
import kr.codesquad.ladder.view.LadderReader;
import kr.codesquad.ladder.view.LadderWriter;

public class LadderGameConsoleController {

    private static final String ALL = "all";
    private static final String EXIT = "춘식이";

    private final LadderReader ladderReader;
    private final LadderWriter ladderWriter;

    public LadderGameConsoleController(LadderReader ladderReader, LadderWriter ladderWriter) {
        this.ladderReader = ladderReader;
        this.ladderWriter = ladderWriter;
    }

    public Names getNamesOfPeoples() {
        Optional<Names> optionalNames = Optional.empty();
        while (optionalNames.isEmpty()) {
            String[] nameArray = ladderReader.readNamesOfPeoples();
            optionalNames = createNames(nameArray);
        }
        return optionalNames.get();
    }

    // nameArray = ["pobi", "hounx"], -> Names = [new Name("pobi"), new Name("hounx")]
    private Optional<Names> createNames(String[] nameArray) {
        Optional<Names> optionalNames = Optional.empty();
        NamesFactory namesFactory = new NamesFactory();
        try {
            Names names = namesFactory.createNames(nameArray);
            optionalNames = Optional.of(names);
        } catch (InvalidNameFormatOfPeopleException | InvalidCountOfPeopleException e) {
            ladderWriter.write(e.getMessage());
        }
        return optionalNames;
    }

    public Destinations getDestinations(int countOfPeople) {
        Optional<Destinations> optionalDestinations = Optional.empty();
        while (optionalDestinations.isEmpty()) {
            String[] dstArray = ladderReader.readDestinations();
            optionalDestinations = createDestinations(dstArray, countOfPeople);
        }
        return optionalDestinations.get();
    }

    private Optional<Destinations> createDestinations(String[] dstArray, int countOfPeople) {
        Optional<Destinations> optionalDestinations = Optional.empty();
        DestinationsFactory destinationsFactory = new DestinationsFactory();
        try {
            Destinations destinations =
                destinationsFactory.createDestinations(dstArray, countOfPeople);
            optionalDestinations = Optional.of(destinations);
        } catch (InvalidCountOfDestinationsException | InvalidFormatOfDestinationException e) {
            ladderWriter.write(e.getMessage());
        }
        return optionalDestinations;
    }

    public LadderGenerator getLadderGenerator() {
        Optional<LadderGenerator> optionalLadderGenerator = Optional.empty();
        while (optionalLadderGenerator.isEmpty()) {
            int maximumLadderHeight = readMaximumLadderHeight();
            optionalLadderGenerator = createLadderGenerator(maximumLadderHeight);
        }
        return optionalLadderGenerator.get();
    }

    private int readMaximumLadderHeight() {
        try {
            return ladderReader.readMaximumLadderHeight();
        } catch (NumberFormatException ignored) {
            ladderWriter.write(new InvalidNumberOfMinimumLadderHeightException().getMessage());
        }
        return 0;
    }

    private Optional<LadderGenerator> createLadderGenerator(int maximumLadderHeight) {
        Optional<LadderGenerator> optionalLadderGenerator = Optional.empty();
        LadderGeneratorFactory ladderGeneratorFactory = new LadderGeneratorFactory();
        try {
            LadderGenerator ladderGenerator = ladderGeneratorFactory.create(maximumLadderHeight);
            optionalLadderGenerator = Optional.of(ladderGenerator);
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
                ladderWriter.writeExitIntro();
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

    public void writeLadderGameStatus(Names namesOfPeoples, Ladder ladder,
        Destinations destinations) {
        ladderWriter.writeNamesOfPeoples(namesOfPeoples);
        ladderWriter.writeLadder(ladder);
        ladderWriter.writeDestinations(destinations);
    }
}
