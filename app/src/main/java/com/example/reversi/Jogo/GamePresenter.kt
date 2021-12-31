package com.example.reversi.Jogo

class GamePresenter {
    private val game: Game = Game()
    private var view: GameView? = null
    val boardSize = game.BOARD_SIZE


    var currentPlayer = Stone.BLACK

    fun onCreate(view: GameView) {
        this.view = view
        view.setCurrentPlayerText(Stone.BLACK)
        game.getInitialPlaces().forEach { putStone(it) }
        view.markCanPutPlaces(game.getAllCanPutPlaces(currentPlayer))
    }

    fun onClickPlace(x: Int, y: Int) {
        val view = view ?: return
        val clickPlace = Place(x, y, currentPlayer)
        if (!game.canPut(clickPlace)) {
            return
        }
        view.clearAllMarkPlaces()
        putStone(clickPlace)
        game.getCanChangePlaces(clickPlace).forEach { putStone(it) }

        if (game.isGameOver()) {
            val blackCount = game.countStones(Stone.BLACK)
            val whiteCount = game.countStones(Stone.WHITE)
            view.showWinner(if (blackCount > whiteCount) Stone.BLACK else Stone.WHITE, blackCount, whiteCount)
            view.finishGame()
        }

        changePlayer()
        view.markCanPutPlaces(game.getAllCanPutPlaces(currentPlayer))

        if (!game.canNext(currentPlayer)) {
            view.clearAllMarkPlaces()
            changePlayer()
            view.markCanPutPlaces(game.getAllCanPutPlaces(currentPlayer))
            return
        }
    }
}