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
    val matchUserAndResult = ladder.matchUserAndResult(existLineInfo, usersNames, inputResult)

    outputView.print(usersNames, draw, inputResult)
    while (true) {
        val searchInfo = inputView.inputSearchInfo(usersNames)
        when (searchInfo.searchType) {
            SearchType.ALL -> outputView.printAll(matchUserAndResult)
            SearchType.SINGLE -> outputView.printSingle(matchUserAndResult.get(searchInfo.name))
            SearchType.CLOSE -> {
                println("게임을 종료합니다.")
                return
            }
        }
    }
}
