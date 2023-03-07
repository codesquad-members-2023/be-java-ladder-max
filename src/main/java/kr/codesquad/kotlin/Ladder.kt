package kr.codesquad.kotlin

import kotlin.random.Random.Default.nextBoolean


class Ladder {


    fun createExistLineMap(peopleCount: Int, ladderHeight: Int): Array<Array<Boolean>> {
        val arr = Array(size = ladderHeight) {
            Array(size = peopleCount - 1) { false }
        }
        (0 until ladderHeight).forEach { i ->
            (0 until peopleCount - 1).forEach { j ->
                arr[i][j] = nextBoolean()
            }
        }
        return arr
    }

    fun draw(existLineMap: Array<Array<Boolean>>): String = with(StringBuilder()) {
        existLineMap.indices.forEach { i ->
            append("|")
            (0 until existLineMap[0].size).forEach { j ->
                append(
                    when {
                        existLineMap[i][j] -> "-"
                        else -> " "
                    }
                )
                append("|")
            }
            append("\n")
        }
        return toString()
    }

}
