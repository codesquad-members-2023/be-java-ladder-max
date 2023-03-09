package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

	private final List<String> resultContainer;

	public Results(final List<String> resultContainer) {
		this.resultContainer = resultContainer;
	}

	public Results(final String results) {
		this(Arrays
			.stream(results.split(","))
			.collect(Collectors.toList()));
	}

	public List<String> getResults() {
		return resultContainer;
	}

	public String getResultOfPos(final int pos) {
		return resultContainer.get(pos);
	}
}
