package kr.codesquad.kotlin

private const val NEW_LINE = "\n"

private const val RESULT_DES = "실행결과"

class OutputView {
    fun print(drawnLadder: String) = println(NEW_LINE.repeat(2) + drawnLadder)
    fun print(names: List<String>, drawnLadder: String) = with(StringBuilder()) {
        append(NEW_LINE.repeat(2))
        append(RESULT_DES)
        append(NEW_LINE.repeat(2))
        names.forEach { append(centerString(it)) }
        append(NEW_LINE)
        append(drawnLadder)
        println(this)
    }

    fun print(usersNames: List<String>, drawnLadder: String, inputResult: List<String>) = with(StringBuilder()) {
        append(NEW_LINE.repeat(2))
        append(RESULT_DES)
        append(NEW_LINE.repeat(2))
        usersNames.forEach { append(centerString(it)) }
        append(NEW_LINE)
        append(drawnLadder)
        inputResult.forEach{append(centerString(it)) }
        println(this)
    }
}

private const val LIMIT_LENGTH = 5

private const val SPACER = " "

private const val INPUT_AREA = LIMIT_LENGTH + 1

fun centerString(name: String): String = with(StringBuilder()) {
    val pair = cutLength(name.length, name)
    val prefixSpacerLength = (INPUT_AREA - pair.first) / 2
    append(SPACER.repeat(prefixSpacerLength)).append(pair.second)
    while (this.length < INPUT_AREA) append(SPACER)
    this.toString()
}

private fun cutLength(
    targetNameLength: Int,
    target: String,
): Pair<Int, String> {
    var nameLength = targetNameLength
    var cutName = target
    when {
        nameLength > LIMIT_LENGTH -> {
            cutName = target.substring(0, INPUT_AREA)
            nameLength = LIMIT_LENGTH
        }
    }
    return nameLength to cutName
}
