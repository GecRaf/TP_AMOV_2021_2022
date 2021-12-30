package com.example.reversi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        actionBar?.hide()

        val button = findViewById<Button>(R.id.buttonPlay)
        button.setOnClickListener{
        val intent = Intent(this, ModosDeJogo::class.java)
            startActivity(intent)
        }

        val profile = findViewById<Button>(R.id.buttonProfile)
        profile.setOnClickListener{
        val pIntent = Intent(this, Perfil::class.java)
        startActivity(pIntent)
        }

    }
}