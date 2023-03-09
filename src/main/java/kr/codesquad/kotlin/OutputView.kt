package kr.codesquad.kotlin

private const val NEW_LINE = "\n"

private const val RESULT_DES = "실행결과"

class OutputView {
    fun print(drawnLadder: String) = println(NEW_LINE.repeat(2) + drawnLadder)
    fun print(names: List<String>, drawnLadder: String) = formatNamesAndDrawnLadder(names, drawnLadder).apply { println(this) }

    private fun formatNamesAndDrawnLadder(names: List<String>, drawnLadder: String) : String {
        with(StringBuilder()) {
            this.append(NEW_LINE.repeat(2))
                .append(RESULT_DES)
                .append(NEW_LINE.repeat(2))
            names.forEach { append(centerString(it)) }
            this.append(NEW_LINE)
                .append(drawnLadder)
            return toString()
        }
    }

    fun print(usersNames: List<String>, drawnLadder: String, inputResult: List<String>) = with(StringBuilder()) {
        append(formatNamesAndDrawnLadder(usersNames,drawnLadder))
        inputResult.forEach { append(centerString(it)) }
        this@with
    }.apply { println(this@apply) }

    fun printAll(matchUserAndResult: Map<String, String>) {
        matchUserAndResult.forEach{entry -> println("${entry.key} : ${entry.value}") }
    }

    fun printSingle(result: String?) {
        println(result)
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
