package kr.codesquad.view;

import kr.codesquad.domain.Ladder;

public class OutputView {

	public void printGetCountOfPersonMsg() {
		System.out.println("참여할 사람은 몇 명인가요?");
	}

	public void printGetHeightOfLadderMsg() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
	}

	public void printFigureOfLadder(final Ladder ladder) {
		System.out.println(ladder);
	}
}
