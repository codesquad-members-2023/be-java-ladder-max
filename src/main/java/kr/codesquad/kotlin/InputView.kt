package kr.codesquad.kotlin

import java.util.*

private const val INPUT_PEOPLE_COUNT = "참여할 사람은 몇 명인가요?"

private const val INPUT_ERROR = "잘못 입력 했습니다."

private const val INPUT_MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?"

private const val IS_DIGIT_PATTERN = "^[1-9][0-9]*$"


class InputView {
    private val scanner = Scanner(System.`in`)
    private val inputViewValidator = InputViewValidator()

    fun inputPeopleCount(): Int = getNumberInput(INPUT_PEOPLE_COUNT)

    fun inputLadderHeight(): Int = getNumberInput(INPUT_MAX_LADDER_HEIGHT)

    private fun getNumberInput(description: String): Int {
        println(description)
        val input = scanner.nextLine()
        if (inputViewValidator.isNumber(input)) {
            return input.toInt()
        }
        println(INPUT_ERROR)
        return getNumberInput(description)
    }
}

class InputViewValidator {
    fun isNumber(input: String): Boolean = input.matches(Regex(IS_DIGIT_PATTERN))
}




