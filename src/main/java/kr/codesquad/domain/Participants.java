package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

	private final List<Participant> participants;

	public Participants(final String participants) {
		validate(participants);
		this.participants = convertToList(participants.split(","));
	}

	private List<Participant> convertToList(final String[] names) {
		List<Participant> participants = new ArrayList<>();
		for (int idx = 0; idx < names.length; idx++) {
			participants.add(new Participant(names[idx], idx));
		}
		return participants;
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

	public int findPosOfParticipant(final String name) {
		return participants.stream()
			.filter(participant -> participant.toString().equals(name))
			.findFirst()
			.get()
			.getPos();
	}

	public List<String> getParticipants() {
		return participants.stream()
			.map(Participant::toString)
			.collect(Collectors.toList());
	}
}
