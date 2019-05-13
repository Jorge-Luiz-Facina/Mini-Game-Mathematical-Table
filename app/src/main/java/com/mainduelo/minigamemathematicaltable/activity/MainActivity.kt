package com.mainduelo.minigamemathematicaltable.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mainduelo.minigamemathematicaltable.R

class MainActivity : AppCompatActivity() {

    private var buttonPlay : Button? = null
    private var buttonScore : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializesButton()
        onClickListenerButton()
    }

    private fun initializesButton(){
        buttonPlay = findViewById(R.id.buttonPlay)
        buttonScore = findViewById(R.id.buttonScore)
    }

    private fun onClickListenerButton(){
        buttonPlay?.setOnClickListener {
            startActivity(Intent(this, SelectLevelActivity::class.java))
        }
        buttonScore?.setOnClickListener {
            startActivity(Intent(this, ScoreActivity::class.java))
        }
    }
}
