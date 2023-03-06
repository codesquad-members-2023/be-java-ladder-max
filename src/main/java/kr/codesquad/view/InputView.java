package kr.codesquad.view;

import java.util.Scanner;

public class InputView {

	private final Scanner sc = new Scanner(System.in);

	public String getInputFromUser() {
		return sc.nextLine();
	}
}
