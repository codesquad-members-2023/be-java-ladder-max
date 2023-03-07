package kr.codesquad.kotlin

import kotlin.random.Random.Default.nextBoolean


class Ladder {


    fun createExistLineMap(peopleCount: Int, ladderHeight: Int): Array<Array<Boolean>> {
        val arr = Array(ladderHeight) {
            Array(peopleCount - 1) { false }
        }
        for (i in 0 until ladderHeight) {
            for (j in 0 until peopleCount - 1) {
                arr[i][j] = nextBoolean()
            }
        }
        return arr
    }

    fun draw(existLineMap: Array<Array<Boolean>>): String {
        val st = StringBuilder()
        existLineMap.indices.forEach { i ->
            st.append("|")
            (0 until existLineMap[0].size).forEach { j ->
                when {
                    existLineMap[i][j] -> {
                        st.append("-")
                    }
                    else -> {
                        st.append(" ")
                    }
                }
                st.append("|")
            }
            st.append("\n")
        }
        return st.toString()
    }

}
