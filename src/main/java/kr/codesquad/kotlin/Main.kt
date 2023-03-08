package kr.codesquad.kotlin

fun main() {
    val inputView = InputView()
    val ladder = Ladder()
    val outputView = OutputView()

    val usersNames = inputView.inputUsersNames()
    val inputResult = inputView.inputResult(usersNames.size)
    val ladderHeight = inputView.inputLadderHeight()

    val existLineInfo = ladder.createExistLineInfoDistant(usersNames.size, ladderHeight)
    val draw = ladder.draw(existLineInfo)

    outputView.print(usersNames, draw, inputResult)
    while (true) {
        val searchInfo = inputView.inputSearchInfo(usersNames)
        when (searchInfo.searchType) {
            SearchType.ALL -> println("all")
            SearchType.SINGLE -> println("single = ${searchInfo.name}")
            SearchType.CLOSE -> {
                println("끝")
                return
            }
        }
    }
}
