package com.mainduelo.minigamemathematicaltable.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.mainduelo.minigamemathematicaltable.R
import com.mainduelo.minigamemathematicaltable.Score

class ScoreActivity : AppCompatActivity(){

    private var punctuation : MutableList<TextView?> = mutableListOf()
    private var textViewTotal : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        initializeTextViewScore()
        upgradeTextViewScore()
        upgradeTextViewScoreTotal()
    }

    private fun initializeTextViewScore(){
        punctuation = mutableListOf(
            findViewById(R.id.textViewScore01),
            findViewById(R.id.textViewScore02),
            findViewById(R.id.textViewScore03),
            findViewById(R.id.textViewScore04),
            findViewById(R.id.textViewScore05),
            findViewById(R.id.textViewScore06),
            findViewById(R.id.textViewScore07),
            findViewById(R.id.textViewScore08),
            findViewById(R.id.textViewScore09),
            findViewById(R.id.textViewScore10))

        textViewTotal = findViewById(R.id.textViewScoreTotal)
    }

    private fun upgradeTextViewScore(){
        var index : Int = 0
        for(textViewScore in punctuation)
            textViewScore?.text = Score.instance.punctuation[index++].toString()
    }

    private fun upgradeTextViewScoreTotal(){
        textViewTotal?.text = Score.instance.getTotal().toString()
    }
}
