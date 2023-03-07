package kr.codesquad.kotlin

import java.util.*

class InputView {
    private val scanner = Scanner(System.`in`)

    fun inputPeopleCount(): Int {
        println("참여할 사람은 몇 명인가요?")
        val input = scanner.nextLine()
        if (isDigit(input)) {
            return input.toInt()
        }
        println("잘못 입력 했습니다.")
        return inputPeopleCount()
    }

    private fun isDigit(input: String): Boolean {
        return input.matches(Regex("^[1-9][0-9]*$"))
    }
}
