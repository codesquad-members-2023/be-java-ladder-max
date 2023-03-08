package kr.codesquad.kotlin

fun main() {
    val inputView = InputView()
    val ladder = Ladder()
    val outputView = OutputView()

    val usersNames = inputView.inputUsersNames()
    val ladderHeight = inputView.inputLadderHeight()

    val existLineInfo = ladder.createExistLineInfoDistant(usersNames.size, ladderHeight)
    val draw = ladder.draw(existLineInfo)

    outputView.print(usersNames,draw)
}
