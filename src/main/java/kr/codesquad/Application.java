package kr.codesquad;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        controller.run();
    }
}