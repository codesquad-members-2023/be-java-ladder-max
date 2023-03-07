package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

	private final List<String> namesOfPerson;
	private final int heightOfLadder;

	public Input(final String namesOfPerson, final String heightOfLadder) {
		validate(namesOfPerson, heightOfLadder);
		this.namesOfPerson = Arrays.stream(namesOfPerson.split(","))
			.map(String::trim)
			.collect(Collectors.toList());
		this.heightOfLadder = Integer.parseInt(heightOfLadder);
	}

	private void validate(final String namesOfPerson, final String heightOfLadder) {
		validateNamesOfPerson(namesOfPerson);
		validateHeightOfLadder(heightOfLadder);
	}

	private void validateNamesOfPerson(final String namesOfPerson) {
		final String[] names = namesOfPerson.split(",");
		Arrays.stream(names)
			.filter(name -> name.length() > 5)
			.findFirst()
			.ifPresent(name -> {
				throw new IllegalArgumentException("[ERROR] 사람 이름은 최대 5글자입니다. 입력 : " + name);
			});
	}

	private void validateHeightOfLadder(final String heightOfLadder) {
		try {
			Integer.parseInt(heightOfLadder);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 사다리의 높이는 정수형 숫자로 입력해야 합니다.", e);
		}
	}

	public List<String> getNamesOfPerson() {
		return namesOfPerson;
	}

	public int getHeightOfLadder() {
		return heightOfLadder;
	}
}
