package kr.codesquad.domain;

public class Height {

	private final int value;

	public Height(final String height) {
		validate(height);
		this.value = Integer.parseInt(height);
	}

	private void validate(final String height) {
		try {
			if (Integer.parseInt(height) < 1) {
				throw new IllegalArgumentException("[ERROR] 사다리의 높이는 1보다 커야 합니다.");
			}
		} catch (final NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 사다리의 높이는 정수형 숫자로 입력해야 합니다.", e);
		}
	}

	public int getValue() {
		return value;
	}
}
