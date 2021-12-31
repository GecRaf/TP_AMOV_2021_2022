package com.example.reversi.Jogo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.reversi.R
import com.example.reversi.Jogo.RegrasDoJogo

class ModosDeJogo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modos_de_jogo)

        supportActionBar?.hide()
        actionBar?.hide()

        val backbutton = findViewById<ImageButton>(R.id.imageButtonBackGameModes)
        backbutton.setOnClickListener{
            val bbIntent = Intent(this, MenuPrincipal::class.java)
            startActivity(bbIntent)
        }

        val howtoplay = findViewById<TextView>(R.id.textViewHowToPlayGameModes)
        howtoplay.setOnClickListener{
            val htpIntent = Intent(this, RegrasDoJogo::class.java)
            startActivity(htpIntent)
        }

    }
}