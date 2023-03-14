package kr.codesquad.view;

import kr.codesquad.util.ValidationHeight;
import kr.codesquad.util.ValidationPlayerName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InputInformation {


    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    ValidationPlayerName validationPlayerName = new ValidationPlayerName();
    ValidationHeight validationHeight = new ValidationHeight();

    public InputInformation() {
    }

    public List<String> putPlayerNames() throws IOException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        try {
            return parsingPlayerNames(br.readLine());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return putPlayerNames();
        }
    }

    private List<String> parsingPlayerNames(String playerNames) {
        return checkListPlayerNames(playerNames.split(","));
    }

    private List<String> checkListPlayerNames(String[] parsingNames) {
        Set<String> listPlayerNames = new HashSet<>();
        for(String name : parsingNames) {
            validationPlayerName.checkNameFormat(name.trim());
            listPlayerNames.add(name.trim());
        }
        validationPlayerName.checkNameDuplication(parsingNames.length, listPlayerNames);

        return new ArrayList<>(listPlayerNames);
    }

    public int putMaxHeight() throws IOException {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return validationHeight.checkValidation(br.readLine());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return putMaxHeight();
        }

    }
}
