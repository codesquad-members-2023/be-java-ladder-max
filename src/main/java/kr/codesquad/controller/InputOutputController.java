package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Players;
import kr.codesquad.domain.Results;
import kr.codesquad.util.Validator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class InputOutputController {

    private final OutputView outputView;
    private final InputView inputView;
    private final Validator validator;

    public InputOutputController() {
        this.validator = new Validator();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    List<String> getPlayers() {
        List<String> playersList;
        do {
            inputView.playerNamePrompt();
            playersList = validator.getValidPlayerFromUser(inputView.getInput());
        } while (playersList == null);
        return playersList;
    }

    int  getHeight() {
        int tempHeight;
        boolean validHeight;
        do {
            inputView.LadderHeightPrompt();
            tempHeight = Integer.parseInt(inputView.getInput());
            validHeight = validator.getValidHeightFromUser(tempHeight);
        } while (!validHeight);
        return tempHeight;
    }

     List getResults(int playerNum) {
         List<String> resultsList;
         do {
             inputView.resultPrompt();
             resultsList = validator.getResultsFromUser(inputView.getInput(), playerNum);
         } while (resultsList == null);
         return resultsList;
    }

    void getExecutionResult(HashMap<String, String> resultMap){
        while (true) {
            inputView.selectPlayerPrompt();
            outputView.getExecutionResult(inputView.getInput(),resultMap);
        }
    }

    void printLadder(Ladder ladder, Players player, Results result) {
        outputView.printLadder(ladder, player, result);
    }
}
