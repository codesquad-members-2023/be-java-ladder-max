package kr.codesquad.kotlin

import java.util.*

private const val INPUT_PEOPLE_COUNT = "참여할 사람은 몇 명인가요?"
private const val INPUT_MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?"
private const val INPUT_USER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"
private const val IS_DIGIT_PATTERN = "^[1-9][0-9]*$"
private const val INPUT_ERROR = "잘못 입력 했습니다."

private const val INPUT_SEARCH_INFO = "결과를 보고 싶은 사람은?"

class InputView {
    private val scanner = Scanner(System.`in`)
    private val inputViewValidator = InputViewValidator()

    fun inputUsersNames(): List<String> {
        println(INPUT_USER_NAME)
        val input = scanner.nextLine()
        if (inputViewValidator.isInputNamesFormat(input)) {
            return input.split(',').toList()
        }
        println(INPUT_ERROR)
        return inputUsersNames()
    }

    fun inputSearchInfo(names: List<String>): SearchInfo {
        println(INPUT_SEARCH_INFO)
        val input: String = scanner.nextLine()
        if (input == SearchType.ALL.value) {
            return SearchInfo(SearchType.ALL, SearchType.ALL.value)
        }
        if (input == SearchType.CLOSE.value) {
            return SearchInfo(SearchType.CLOSE, SearchType.CLOSE.value)
        }
        if (names.contains(input)) {
            return SearchInfo(SearchType.SINGLE, input)
        }
        println(INPUT_ERROR)
        return inputSearchInfo(names)
    }

    fun inputResult(usersSize: Int): List<String> {
        println(INPUT_USER_NAME)
        val input = scanner.nextLine()
        if (inputViewValidator.isRightResultPattern(input)) {
            val result = input.split(",")
            if (result.size == usersSize) {
                return result.toList()
            }
        }
        println(INPUT_ERROR)
        return inputUsersNames()
    }

    fun inputUserCount(): Int = getNumberInput(INPUT_PEOPLE_COUNT)

    fun inputLadderHeight(): Int = getNumberInput(INPUT_MAX_LADDER_HEIGHT)

    private fun getNumberInput(description: String): Int {
        println(description)
        val input = scanner.nextLine()
        return when {
            inputViewValidator.isNumber(input) -> {
                input.toInt()
            }

            else -> {
                println(INPUT_ERROR)
                getNumberInput(description)
            }
        }
    }
}

data class SearchInfo(val searchType: SearchType, val name: String)

enum class SearchType(val value: String) { ALL("all"), SINGLE(""), CLOSE("춘식이") }

class InputViewValidator {
    fun isNumber(input: String): Boolean = input.matches(Regex(IS_DIGIT_PATTERN))
    fun isInputNamesFormat(input: String): Boolean = input.matches(Regex("^[a-z]+(,[a-z]+)+\$"))
    fun isRightResultPattern(input: String): Boolean =
            input.matches(Regex("^(꽝|([0-9]+[1-9]*))(,(꽝|([0-9]+[1-9]*)))*\$"))


}




