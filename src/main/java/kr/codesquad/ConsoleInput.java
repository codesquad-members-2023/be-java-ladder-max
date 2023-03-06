package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {
    private final BufferedReader br;
    private final LadderValidator validator;

    public ConsoleInput(LadderValidator validator) {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.validator = validator;
    }

    public int inputPerson(){
        String text;
        while(true){
            try {
                ConsoleOutput.printInputPersonIntro();
                text = br.readLine();
                if(!validator.validatePerson(text)){
                    throw new InvalidPersonNumber();
                }
                break;
            } catch (InvalidPersonNumber e) {
                ConsoleOutput.printInvalidInputNumber(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return Integer.parseInt(text);
    }

    public int inputMaximumLadderHeight(){
        String text;
        while(true){
            try {
                ConsoleOutput.printInputMaximumLadderHeightIntro();
                text = br.readLine();
                if(!validator.validateLadderHeight(text)){
                    throw new InvalidMaximumLadderHeight();
                }
                break;
            } catch (InvalidMaximumLadderHeight e) {
                ConsoleOutput.printInvalidInputNumber(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return Integer.parseInt(text);
    }
}
