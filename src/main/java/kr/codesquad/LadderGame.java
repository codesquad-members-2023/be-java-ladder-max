package kr.codesquad;

public class LadderGame {
    private final Output output = new Output();
    private final Input input = new Input();


    public void start() {
        int[] userInput = getLadderInput();

        Ladder ladder = new Ladder();

        ladder.makeLadderShape(userInput);

        output.printLadder(ladder.getLadder());
    }

    private int[] getLadderInput() {
        output.printNumberOfPeople();
        int people = Integer.parseInt(input.getInput());

        output.printHeightOfLadder();
        int height = Integer.parseInt(input.getInput());

        return new int[]{people, height};
    }

}
