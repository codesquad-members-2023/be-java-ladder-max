package kr.codesquad;

public class Ladder {
    private final Output output = new Output();
    private final Input input = new Input();

    public void start() {
        int[] userInput = getInput();

        String[][] ladder = makeLadderShape(userInput);

        output.printLadder(ladder);
    }

    private int[] getInput() {
        output.printNumberOfPeople();
        int people = Integer.parseInt(input.getInput());

        output.printHeightOfLadder();
        int height = Integer.parseInt(input.getInput());

        return new int[]{people, height};
    }

    private String[][] makeLadderShape(int[] userInput) {
        String[][] customLadder = new String[userInput[1]][userInput[0] * 2 - 1];
        for (int i = 0; i < customLadder.length; i++){
            fillLadderLine(customLadder[i]);
        }

        return customLadder;
    }

    private void fillLadderLine(String[] customLadder) {
        for (int i = 0; i < customLadder.length; i++){
            if (i % 2 == 0)
                customLadder[i] = "|";
            else
                customLadder[i] = randomLadderStep();
        }
    }

    private String randomLadderStep() {
        double rand = Math.random();
        String result = (rand <= 0.5) ? " " : "-";
        return result;
    }
}
