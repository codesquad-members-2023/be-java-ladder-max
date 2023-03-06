package kr.codesquad.view;

import kr.codesquad.domain.Ladder;

public class OutputView {

	public void printGetNamesOfPersonMsg() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
	}

	public void printGetHeightOfLadderMsg() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
	}

	public void printFigureOfLadder(final Ladder ladder) {
		System.out.println(ladder);
	}
}
