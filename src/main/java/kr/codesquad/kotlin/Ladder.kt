package kr.codesquad.kotlin

import kotlin.random.Random.Default.nextBoolean


class Ladder {


    fun existLineMap(peopleCount: Int, ladderHeight: Int): Array<Array<Boolean>> {
        val arr = Array(ladderHeight) {
            Array(peopleCount - 1) { false }
        }
        for (i in 0 until ladderHeight) {
            for (j in 0 until peopleCount - 1) {
                arr[i][j] = nextBoolean()
            }
        }
        println(arr.contentDeepToString())
        return arr
    }
}
