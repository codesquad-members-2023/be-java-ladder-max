package kr.codesquad.ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;
import java.util.regex.Pattern;
import kr.codesquad.ladder.domain.InvalidCountOfLadderResultException;
import kr.codesquad.ladder.domain.InvalidLengthOfLadderResultException;
import kr.codesquad.ladder.domain.InvalidNameFormatOfPeopleException;
import kr.codesquad.ladder.domain.InvalidNumberOfMinimumLadderHeightException;
import kr.codesquad.ladder.domain.InvalidCountOfPeopleException;
import kr.codesquad.ladder.domain.LadderGenerator;
import kr.codesquad.ladder.domain.LadderResults;
import kr.codesquad.ladder.domain.Names;

public class LadderConsoleReader implements LadderReader {

    private static final Pattern DELIMITER = Pattern.compile("\\s*,\\s*");

    private final BufferedReader reader;
    private final LadderWriter ladderWriter;

    public LadderConsoleReader(BufferedReader reader,
        LadderWriter ladderWriter) {
        this.reader = reader;
        this.ladderWriter = ladderWriter;
    }

    @Override
    public Names readNameOfPeople() {
        Optional<Names> optionalNames = Optional.empty();
        while (optionalNames.isEmpty()) {
            ladderWriter.writeNamesOfPeopleIntro();
            optionalNames = readNamesOfPeopleTextAndToStringList();
        }
        return optionalNames.get();
    }

    private Optional<Names> readNamesOfPeopleTextAndToStringList() {
        Optional<Names> optionalNames = Optional.empty();
        try {
            String text = reader.readLine();
            String[] names = text.split(DELIMITER.pattern());
            optionalNames = Optional.of(new Names(names));
        } catch (InvalidNameFormatOfPeopleException | InvalidCountOfPeopleException e) {
            ladderWriter.write(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return optionalNames;
    }

    @Override
    public LadderGenerator readMaximumLadderHeight() {
        Optional<LadderGenerator> optionalLadderGenerator = Optional.empty();
        while (optionalLadderGenerator.isEmpty()) {
            ladderWriter.writeMaximumLadderHeightIntro();
            optionalLadderGenerator = readMaximumLadderHeightTextAndToInt();
        }
        return optionalLadderGenerator.get();
    }

    private Optional<LadderGenerator> readMaximumLadderHeightTextAndToInt() {
        Optional<LadderGenerator> optionalLadderGenerator = Optional.empty();
        try {
            String text = reader.readLine();
            int maximumHeight = Integer.parseInt(text);
            optionalLadderGenerator = Optional.of(
                new LadderGenerator(maximumHeight));
        } catch (InvalidNumberOfMinimumLadderHeightException | NumberFormatException e) {
            ladderWriter.write(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return optionalLadderGenerator;
    }

    @Override
    public LadderResults readLadderResults(int countOfPeople) {
        Optional<LadderResults> optionalLadderResults = Optional.empty();
        while (optionalLadderResults.isEmpty()) {
            ladderWriter.writeLadderResultIntro();
            optionalLadderResults = readLadderResultsText(countOfPeople);
        }
        return optionalLadderResults.get();
    }

    private Optional<LadderResults> readLadderResultsText(int countOfPeople) {
        Optional<LadderResults> optionalLadderResults = Optional.empty();
        try {
            String text = reader.readLine();
            String[] ladderResults = text.split(DELIMITER.pattern());
            optionalLadderResults = Optional.of(new LadderResults(ladderResults, countOfPeople));
        } catch (InvalidLengthOfLadderResultException | InvalidCountOfLadderResultException e) {
            ladderWriter.write(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return optionalLadderResults;
    }
}
