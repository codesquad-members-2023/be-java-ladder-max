package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

	private final List<String> participants;

	public Participants(final String participants) {
		validate(participants);
		this.participants = Arrays.stream(participants.split(","))
			.map(String::trim)
			.collect(Collectors.toList());
	}

	private void validate(final String participants) {
		final String[] names = participants.split(",");
		Arrays.stream(names)
			.filter(name -> name.length() > 5)
			.findFirst()
			.ifPresent(name -> {
				throw new IllegalArgumentException("[ERROR] 사람 이름은 최대 5글자입니다. 입력 : " + name);
			});
	}

	public List<String> getParticipants() {
		return participants;
	}
}
