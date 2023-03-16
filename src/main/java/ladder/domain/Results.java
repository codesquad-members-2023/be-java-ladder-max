package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Results {
    private final String[] categories;
    private final Map<String, Integer> results = new HashMap<>();

    public Results(String[] categories) {
        this.categories = categories;
    }

    public void addResult(String name, int index) {
        results.put(name, index);
    }

    public String makeResultLabels(int size) {
        StringBuilder builder = new StringBuilder();
        for (String category : categories) {
            int frontBlank = (size - category.length()) / 2;
            int backBlank = (size - category.length()) % 2;
            builder.append(" ".repeat(frontBlank));
            builder.append(category);
            builder.append(" ".repeat(frontBlank + backBlank));
        }
        return builder.toString();
    }

    public String findResultByName(String name) {
        if (name.equals("all")) {
            return findAllResults();
        }
        checkIsPlayerName(name);
        return categories[results.get(name)];
    }

    private void checkIsPlayerName(String name) {
        if (!results.containsKey(name)) {
            throw new IllegalArgumentException("참여자 목록에 없는 이름입니다.");
        }
    }

    private String findAllResults() {
        StringBuilder builder = new StringBuilder();
        for (String name : results.keySet()) {
            builder.append(name).append(" : ").append(categories[results.get(name)]).append("\n");
        }
        builder.delete(builder.lastIndexOf("\n"), builder.lastIndexOf("\n") + 1);
        return builder.toString();
    }
}
