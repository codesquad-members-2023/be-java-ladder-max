package Ladder2.domain;

import Ladder2.view.Input;
import Ladder2.view.Output;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Participants {
    private List<Name> names = new ArrayList<>();

    public Participants() throws IOException {
        try {
            this.getNameList();
        } catch (IllegalArgumentException e) {
            throw e;
        }

    }

    public List<Name> getNames() {
        return this.names;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int emptyCount = 0;
        int nameCount = 0;
        int sizeOfLine = Name.nameSizeRestriction + 1;
        for (Name name : names) {
            emptyCount = sizeOfLine - nameCount - ((name.getLength() / 2) + (name.getLength() % 2));
            nameCount = name.getLength() - (name.getLength() / 2) - (name.getLength() % 2);
            sb.append(createEmptyString(emptyCount));
            sb.append(name.getName());
        }
        return sb.append("\n").toString();
    }

    private void getNameList() throws IOException {
        Input input = new Input();
        Output output = new Output();
        output.promptGetNames();
        String namesString = input.getInputFromUser();
        this.namesFormatValidation(namesString);
        StringTokenizer st = new StringTokenizer(namesString, ",");

        while (st.hasMoreTokens()) {
            this.names.add(new Name(st.nextToken()));

        }
    }

    private void namesFormatValidation(String input) {
        if (!input.matches("^[a-zA-Z]+(?:,[a-zA-Z]+)*$")) {
            throw new IllegalArgumentException("입력 형식이 잘못 되었습니다.");
        }
    }



    private String createEmptyString(int emptyCount) {
        String empty = "";
        for (int i = 0; i < emptyCount; i++) {
            empty += " ";
        }
        return empty;
    }
}

