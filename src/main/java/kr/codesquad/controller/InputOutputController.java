package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderHeight;
import kr.codesquad.domain.Players;
import kr.codesquad.domain.Results;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.HashMap;

public class InputOutputController {

    private OutputView outputView;
    private InputView inputView;

    public InputOutputController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    void setupGame(Players players, LadderHeight ladderHeight, Results result) {
        getPlayers(players);
        getResults(result, players.getPlayersList().size());
        getHeight(ladderHeight);
    }

    private void getPlayers(Players players) {
        inputView.playerNamePrompt();
        while (!players.getValidPlayerFromUser(inputView.getInput())) {
        }
    }

    private void getHeight(LadderHeight ladderHeight) {
        inputView.LadderHeightPrompt();
        while (!ladderHeight.getValidHeightFromUser(Integer.parseInt(inputView.getInput()))) ;
    }

    private void getResults(Results result, int playerNum) {
        inputView.resultPrompt();
        while (!result.getResultsFromUser(inputView.getInput(), playerNum)) ;
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
