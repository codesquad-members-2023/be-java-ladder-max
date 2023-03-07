package kr.codesquad.kotlin

fun main() {
    val inputView = InputView()
    val peopleCount = inputView.inputPeopleCount()
    val ladderHeight = inputView.inputLadderHeight()
    val ladder = Ladder()
    ladder.existLineMap(peopleCount, ladderHeight)
}
