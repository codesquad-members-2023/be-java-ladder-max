package kr.codesquad.domain.destination;

public class Destination {
    private final int MAX_NAME_LENGTH = 5;
    private final int MIN_NAME_LENGTH = 1;
    private final String name;

    public Destination(String name) {
        validateDestinationName(name);
        this.name = name;
    }

    private void validateDestinationName(String name) {
        if(name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 도착지 이름은 1글자 이상, 5글자 이하로 입력해 주세요.(※ " + name + ")");
        }
    }

    public String getName() {
        return name;
    }

    public String getCenterAlignedName() {
        return String.format("%"+MAX_NAME_LENGTH+"s"
                , String.format("%-" + (((MAX_NAME_LENGTH - name.length()) / 2) + name.length()) + "s", name));
    }

}
