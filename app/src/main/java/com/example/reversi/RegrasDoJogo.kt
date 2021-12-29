package com.example.reversi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class RegrasDoJogo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regras_do_jogo)

        supportActionBar?.hide()
        actionBar?.hide()


        val backbutton = findViewById<ImageButton>(R.id.imageButtonBackRules)
        backbutton.setOnClickListener{
            val bbIntent = Intent(this, ModosDeJogo::class.java)
            startActivity(bbIntent)
        }
    }
}