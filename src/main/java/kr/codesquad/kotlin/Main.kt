package kr.codesquad.kotlin

fun main() {
    val inputView = InputView()
    val ladder = Ladder()
    val outputView = OutputView()

    val peopleCount = inputView.inputPeopleCount()
    val ladderHeight = inputView.inputLadderHeight()

    val existLineMap = ladder.createExistLineMap(peopleCount, ladderHeight)
    val draw = ladder.draw(existLineMap)

    outputView.print(draw)
}
