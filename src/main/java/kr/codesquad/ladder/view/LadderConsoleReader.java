package kr.codesquad.ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;
import kr.codesquad.ladder.domain.InvalidNameFormatOfPeopleException;
import kr.codesquad.ladder.domain.InvalidNumberOfMinimumLadderHeightException;
import kr.codesquad.ladder.domain.InvalidCountOfPeopleException;
import kr.codesquad.ladder.domain.LadderGenerator;
import kr.codesquad.ladder.domain.Names;

public class LadderConsoleReader implements LadderReader {

    private static final int MINIMUM_PERSON = 2;
    private static final int MINIMUM_HEIGHT = 1;

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
        Optional<Names> names = Optional.empty();
        try {
            String text = reader.readLine();
            names = Optional.of(new Names(text, MINIMUM_PERSON));
        } catch (InvalidNameFormatOfPeopleException | InvalidCountOfPeopleException e) {
            ladderWriter.write(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return names;
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
                new LadderGenerator(maximumHeight, MINIMUM_HEIGHT));
        } catch (InvalidNumberOfMinimumLadderHeightException | NumberFormatException e) {
            ladderWriter.write(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return optionalLadderGenerator;
    }
}
