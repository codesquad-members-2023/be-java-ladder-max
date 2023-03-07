package kr.codesquad.kotlin

fun main() {
    val inputView = InputView()
    val peopleCount = inputView.inputPeopleCount()
    val ladderHeight = inputView.inputLadderHeight()
    println(peopleCount)
    println(ladderHeight)
}
