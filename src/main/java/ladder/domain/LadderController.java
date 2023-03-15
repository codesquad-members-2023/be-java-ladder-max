package ladder.domain;

import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public void run() {
        Players userNames = getPlayers();
        int countOfPerson = userNames.getCountOfPerson();
        int heightOfLadder = getHeightOfLadder();
        Ladder ladder = new Ladder(countOfPerson, heightOfLadder);
        outputView.printNames(userNames.toString());
        outputView.printLadder(ladder);
    }

    private Players getPlayers() {
        try {
            outputView.inputPeople();
            String name = inputView.getInput();
            return new Players(name);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayers();
        }
    }

    private int getHeightOfLadder() {
        outputView.inputLadder();
        return Integer.parseInt(inputView.getInput());
    }
}
