package kr.codesquad.domain;

public class Validator {
    public boolean validateNames(String[] names) {
        try {
            NamesToName(names);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("플레이어의 이름은 1글자부터 최대 5글자까지 가능합니다.");
            return false;
        }
    }
    private void NamesToName(String[] names) {
        for (String name : names) {
            limitNameSize(name);
        }
    }

    private void limitNameSize(String name) {
        if (name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException(name+ "은 형식에 맞지 않습니다.");
        }
    }

    public boolean validateResults(String[] results, int namesSize) {
        try {
            ResultsToResult(results , namesSize);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("결과는 1글자부터 최대 5글자까지 가능하고 결과 개수는 플레이어 명 수와 같아야 합니다.");
            return false;
        }
    }

    private void ResultsToResult(String[] results, int nameSize) {
        for (String result : results) {
            limitResultSize(result);
            isSameSize(results.length, nameSize);
        }
    }

    private void limitResultSize(String result) {
        if (result.length() > 5 || result.length() == 0) {
            throw new IllegalArgumentException(result+ "은 형식에 맞지 않습니다.");
        }
    }

    private void isSameSize(int resultsSize, int namesSize) {
        if (resultsSize != namesSize) {
            throw new IllegalArgumentException("플레이어 명 수와 결과 개수가 같지 않습니다.");
        }
    }

    public boolean validateLadder(String answer) {
        try {
            limitLadderSize(Integer.parseInt(answer));
            return true;
        } catch (NumberFormatException e) {
            System.out.println("정수가 아닙니다.");
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("사다리 높이는 0보다 커야 합니다.");
            return false;
        }
    }

    private void limitLadderSize(int countOfLadder) {
        if (countOfLadder <= 0) {
            throw new IllegalArgumentException(countOfLadder + "은 0보다 작습니다.");
        }
    }
}
