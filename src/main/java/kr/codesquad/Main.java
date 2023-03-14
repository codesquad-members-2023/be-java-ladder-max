package kr.codesquad;

import kr.codesquad.controller.GameController;
import kr.codesquad.exception.GameProgressException;

import java.io.IOException;

public class Main {

    private static GameController controller = new GameController();

    private static void runApplication() {
        try {
            controller.runLadderGame();
        } catch (NumberFormatException e) {
            System.out.println("잘못된 값을 입력하였습니다. 다시 입력해 주세요.");
        } catch (IllegalArgumentException | GameProgressException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println();
        }
    }

    public static void main(String[] args) {

        while (true) {
            runApplication();
        }

    }
}
