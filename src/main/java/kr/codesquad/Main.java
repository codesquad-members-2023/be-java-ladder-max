package kr.codesquad;

import kr.codesquad.controller.LadderGameController;
import kr.codesquad.service.LadderGame;
import kr.codesquad.view.Screen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final LadderGameController ladderGameController = new LadderGameController(new LadderGame(), new Screen(new Scanner(System.in)));
        ladderGameController.run();
    }
}