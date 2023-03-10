package kr.codesquad.domain;

import kr.codesquad.view.OutputView;

import java.util.List;

public enum Type {

    ALL("all") {
        @Override
        public void execute(List<String> finals, OutputView outputView) {
            outputView.printResults();
            finals.stream().forEach(System.out::println);
        }
    },
    END("춘식이") {
        @Override
        public void execute(List<String> finals, OutputView outputView) {
            outputView.exit();
        }
    };

    String input;

    Type(String input) {
        this.input = input;
    }

    public static Type find(String input) {
        if(Type.END.input.equals(input)) {
            return Type.END;
        }
        if(Type.ALL.input.equals(input)) {
            return Type.ALL;
        }
        return null;
    }

    public abstract void execute(List<String> finals, OutputView outputView);

}
