package kr.codesquad.kotlin

fun main() {
    val inputView = InputView()
    val peopleCount = inputView.inputPeopleCount()
    val ladderHeight = inputView.inputLadderHeight()
    val ladder = Ladder()
    val existLineMap = ladder.createExistLineMap(peopleCount, ladderHeight)
    val draw = ladder.draw(existLineMap)
    val outputView = OutputView()
    outputView.print(draw)
}
