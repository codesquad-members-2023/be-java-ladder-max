package kr.codesquad;

import java.util.List;

public class InputHandler {
    private final Input input = new Input();
    private final Validator validator = new Validator();

    public List<String> inputValidatedPlayers() {
        List<String> players = null;

        try {
            players = input.inputPlayers();
            validator.validatePlayers(players);
        }
        catch (RuntimeException e) {
            players = inputValidatedPlayers();
        }
        return players;
    }

    public int inputValidatedHeight() {
        int height = 0;

        try{
            height = input.inputHeight();
        }
        catch (RuntimeException e) {
            height = inputValidatedHeight();
        }
        return height;
    }
}
