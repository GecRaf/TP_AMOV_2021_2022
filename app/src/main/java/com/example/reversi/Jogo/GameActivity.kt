package com.example.reversi.Jogo

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.reversi.R

class GameActivity : AppCompatActivity() {

    lateinit var placeList: List<List<ImageView>>
    val presenter = GamePresenter()
    val boardSize = presenter.boardSize

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        placeList = arrayOfNulls<List<ImageView>>(boardSize)
            .mapIndexed { x, list ->
                arrayOfNulls<ImageView>(boardSize).mapIndexed { y, imageView ->
                    val place = layoutInflater.inflate(R.layout.game_grid, null)
                    place.setOnClickListener { presenter.onClickPlace(x, y) }
                    gamePlacesGrid.addView(place)
                    place.findViewById(R.id.gamePlaceImageView) as ImageView
                }
            }
    }

    override fun putStone(place: Place) {
        val imageRes = when (place.stone) {
            Stone.BLACK -> R.drawable.black_stone
            Stone.WHITE -> R.drawable.white_stone
            Stone.NONE -> throw IllegalArgumentException()
        }
        placeList[place.x][place.y].setImageResource(imageRes)
    }

    override fun setCurrentPlayerText(player: Stone) {
        val color = when (player) {
            Stone.BLACK -> "黒"
            Stone.WHITE -> "白"
            Stone.NONE -> throw IllegalArgumentException()
        }
        gameCurrentPlayerText.text = getString(R.string.textGameCurrentPlayer, color)
    }

    override fun showWinner(player: Stone, blackCount: Int, whiteCount: Int) {
        val color = when (player) {
            Stone.BLACK -> "黒"
            Stone.WHITE -> "白"
            Stone.NONE -> throw IllegalArgumentException()
        }
        Toast.makeText(this, getString(R.string.textGameWinner, blackCount, whiteCount, color), Toast.LENGTH_SHORT).show()
    }

    override fun finishGame() {
        finish()
    }

    override fun markCanPutPlaces(places: List<Place>) {
        places.forEach { placeList[it.x][it.y].setBackgroundColor(ContextCompat.getColor(this, R.color.green_light)) }
    }

    override fun clearAllMarkPlaces() {
        placeList.flatMap { it }.forEach { it.setBackgroundColor(ContextCompat.getColor(this,
            R.color.green
        )) }
    }

}

}