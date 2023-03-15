package kr.codesquad.domain;

import java.util.List;

import static kr.codesquad.util.ValidationPlayerName.MAX_LENGTH;

public class Player {

    public String nameLabelFormat(List<String> playerList) {
        String nameLabel = "";
        for(String name : playerList) {
            int nameCellLength = MAX_LENGTH + 1;
            int nameLength = name.length();
            int leftPadding = ((nameCellLength - nameLength) / 2) + ((nameCellLength - nameLength) % 2);
            int rightPadding = (nameCellLength - nameLength) / 2;
            nameLabel += String.format("%s%s%s", " ".repeat(leftPadding), name, " ".repeat(rightPadding));
        }
        return nameLabel;
    }
}
