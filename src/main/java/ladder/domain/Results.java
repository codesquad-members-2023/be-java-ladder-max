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
            boolean isNotMaxLength = category.length() < size;
            builder.append(" ".repeat(frontBlank));
            builder.append(category);
            builder.append(" ".repeat(frontBlank == 0 && isNotMaxLength ? backBlank : frontBlank));
        }
        return builder.toString();
    }

    public String findResultByName(String name) {
        if (name.equals("all")) {
            return findAllResults();
        }
        return categories[results.get(name)];
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
