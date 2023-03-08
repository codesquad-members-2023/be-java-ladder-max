package kr.codesquad.kotlin

import kotlin.random.Random.Default.nextBoolean


private const val EXIST_DELIMITER = "-----"

private const val EMPTY_DELIMITER = "     "

private const val USER_DELIMITER = "|"

private const val NEXT_LINE = "\n"

private const val PREFIX_SPACER = "   "

class Ladder {


    fun createExistLineInfoDistant(usersCount: Int, ladderHeight: Int): List<List<Boolean>> =
        with(ArrayList<List<Boolean>>()) {
            for (i in 0 until ladderHeight) {
                add(
                    addRowExistLineInfo(usersCount)
                )
            }
            this@with
        }
    private fun addRowExistLineInfo(usersCount: Int) = with(ArrayList<Boolean>()) {
        for (j in 0 until usersCount - 1) {
            val currentBoolean = nextBoolean()
            add((currentBoolean && j == 0) || (j != 0 && currentBoolean && !get(j - 1)))
        }
        this@with
    }


    fun createExistLineInfo(usersCount: Int, ladderHeight: Int): Array<Array<Boolean>> {
        val arr = Array(size = ladderHeight) {
            Array(size = usersCount - 1) { false }
        }
        (0 until ladderHeight).forEach { i ->
            (0 until usersCount - 1).forEach { j ->
                arr[i][j] = nextBoolean()
            }
        }
        return arr
    }

    fun draw(existLineInfo: Array<Array<Boolean>>): String = with(StringBuilder()) {
        existLineInfo.indices.forEach { i ->
            append(USER_DELIMITER)
            (0 until existLineInfo[0].size).forEach { j ->
                append(
                    when {
                        existLineInfo[i][j] -> "-"
                        else -> " "
                    }
                )
                append(USER_DELIMITER)
            }
            append(NEXT_LINE)
        }
        return toString()
    }

    fun draw(existLineInfo: List<List<Boolean>>): String = with(StringBuilder()) {
        existLineInfo.indices.forEach { i ->
            append(PREFIX_SPACER)
            append(USER_DELIMITER)
            (0 until existLineInfo[0].size).forEach { j ->
                append(
                    when {
                        existLineInfo[i][j] -> EXIST_DELIMITER
                        else -> EMPTY_DELIMITER
                    }
                )
                append(USER_DELIMITER)
            }
            append(NEXT_LINE)
        }
        return toString()
    }

    fun matchUserAndResult(
        existLineInfo: List<List<Boolean>>,
        usersNames: List<String>,
        inputResult: List<String>,
    ): Map<String, String> {
        val resultStore = HashMap<String, String>()
        for (i  in usersNames.indices) {
            var currentPosition = i
            for (j in existLineInfo.indices) {
                if (currentPosition < usersNames.size-1 && existLineInfo[j][currentPosition]) {
                    currentPosition++
                } else if (currentPosition > 0 && existLineInfo[j][currentPosition-1]) {
                    currentPosition--
                }
            }
            resultStore.put(usersNames.get(i), inputResult.get(currentPosition))
        }
        return resultStore
    }
}
