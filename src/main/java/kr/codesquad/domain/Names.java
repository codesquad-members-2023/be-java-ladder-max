package kr.codesquad.domain;

public class Names extends Elements{
    public Names(String inputName) {
        super(inputName);
    }

    public int indexOf(String element) {
        return elements.indexOf(element);
    }
}
