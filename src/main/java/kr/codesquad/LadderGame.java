package kr.codesquad;

public class LadderGame {
    private final Output output = new Output();
    private final Input input = new Input();


    public void start() {
        UserInput userInput = getLadderInput();

        Ladder ladder = new Ladder();

        ladder.makeLadderShape(userInput);

        output.printLadder(ladder.getLadder());
    }

    private UserInput getLadderInput() {

        output.printNameOfPeople();
        String names = input.getInput();

        output.printHeightOfLadder();
        int height = Integer.parseInt(input.getInput());

        return new UserInput(names, height);
    }

}
