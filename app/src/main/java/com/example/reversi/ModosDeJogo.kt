package com.example.reversi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ModosDeJogo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modos_de_jogo)

        supportActionBar?.hide()
        actionBar?.hide()

        val backbutton = findViewById<Button>(R.id.imageButtonBack)
        backbutton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}