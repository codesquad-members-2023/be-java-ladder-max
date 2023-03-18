package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class NamesFactory {

    public Names createNames(String[] nameArray) {
        List<Name> nameList = createNameOfPeopleListInstance(nameArray);
        return new Names(nameList);
    }

    private List<Name> createNameOfPeopleListInstance(String[] nameArray) {
        List<Name> nameList = new ArrayList<>();
        for (String name : nameArray) {
            nameList.add(new Name(name));
        }
        return nameList;
    }

}
