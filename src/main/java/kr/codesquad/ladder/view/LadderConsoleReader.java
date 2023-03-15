package kr.codesquad.ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;
import java.util.regex.Pattern;
import kr.codesquad.ladder.exception.InvalidNameFormatOfPeopleException;
import kr.codesquad.ladder.exception.InvalidNumberOfMinimumLadderHeightException;
import kr.codesquad.ladder.domain.LadderGenerator;
import kr.codesquad.ladder.domain.Name;
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
    public String[] readNamesOfPeoples() {
        ladderWriter.writeNamesOfPeopleIntro();
        String names = readLine();
        return splitTextByDelimiterPattern(names, DELIMITER.pattern());
    }

    @Override
    public int readMaximumLadderHeight() {
        ladderWriter.writeMaximumLadderHeightIntro();
        return Integer.parseInt(readLine());
    }

    @Override
    public String[] readDestinations() {
        ladderWriter.writeLadderResultIntro();
        String destinationsText = readLine();
        return splitTextByDelimiterPattern(destinationsText, DELIMITER.pattern());
    }

    @Override
    public String readNameOfPeopleForLadderResult(Names names) {
        ladderWriter.writeNameForLadderResultIntro(names);
        return readLine();
    }

    private String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String[] splitTextByDelimiterPattern(String text, String delimiterPattern) {
        return text.split(delimiterPattern);
    }
}
