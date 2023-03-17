package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import kr.codesquad.ladder.exception.InvalidCountOfPeopleException;
import kr.codesquad.ladder.exception.InvalidNameFormatOfPeopleException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class NamesFactory {

    public Optional<Names> createNames(String[] nameArray) {
        Optional<Names> optionalNames = Optional.empty();
        try {
            List<Name> nameList = createNameOfPeopleListInstance(nameArray);
            optionalNames = Optional.of(new Names(nameList));
        } catch (InvalidNameFormatOfPeopleException | InvalidCountOfPeopleException e) {
//            ladderWriter.write(e.getMessage());
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

}
