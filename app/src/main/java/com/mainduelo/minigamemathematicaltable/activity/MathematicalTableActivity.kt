package com.mainduelo.minigamemathematicaltable.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.os.CountDownTimer
import com.mainduelo.minigamemathematicaltable.ManipulationColunm
import com.mainduelo.minigamemathematicaltable.MathematicalTableColor
import com.mainduelo.minigamemathematicaltable.R
import com.mainduelo.minigamemathematicaltable.Score
import com.mainduelo.minigamemathematicaltable.component.view.ButtonTable

class MathematicalTableActivity: AppCompatActivity() {

    private val MISTAKES : String = "Mistakes:"
    private val HITS : String = "Hits:"

    private var countDownTimer: CountDownTimer? = null
    private var time: Int = 60
    private var timeMilli: Long = 60500

    private var buttonsColunmLeft : MutableList<ButtonTable?> = mutableListOf()
    private var buttonsColunmRight : MutableList<ButtonTable?> = mutableListOf()

    private var buttonBefore : ButtonTable? = null
    private var textViewHits : TextView? = null
    private var textViewMistakes : TextView? = null
    private var textViewStopwatch : TextView? = null
    private var textViewScore : TextView? = null

    private var hits : Int = 0
    private var mistakes : Int = 0
    private var score : Int = 0

    companion object {
        private var tableNumber : Int = 1
         fun setTableNumber(tableNumber : Int){
             if(tableNumber in 1..10)
                Companion.tableNumber = tableNumber
             else
                 Companion.tableNumber = 1
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
        initializeButtonColunmLeft()
        initializeButtonColunmRight()
        initializeTextView()

        setButtons()

        initializeButtonOnAction()
        stopwatch()
    }

    private fun setButtons(){
        buttonsColunmLeft = ManipulationColunm(buttonsColunmLeft).setLeftColunm(tableNumber).buttons
        buttonsColunmRight = ManipulationColunm(buttonsColunmRight).setRightColunm(tableNumber).buttons
    }

    private fun clickButton(button : ButtonTable){
        if(buttonBefore == null)
            firstButtonSelected(button)
        else if(buttonBefore!!.getNumber().equals(button.getNumber()))
            secondButtonHit(button)
        else
            secondButtonWrong()

        textViewScore?.text = "$score"
        Score.instance.upgradePunctuation(score, (tableNumber -1))
        nextLevel()
    }

    private fun firstButtonSelected(button : ButtonTable){
        button.isClickable = false
        buttonBefore = button
        button.setBackgroundResource(R.color.selected)
    }

    private fun secondButtonHit(button : ButtonTable){
        buttonBefore?.setBackgroundColor(MathematicalTableColor.instance.getColorButton(++hits, this))
        button.setBackgroundColor(MathematicalTableColor.instance.getColorButton(hits, this))
        button.isClickable = false
        buttonBefore = null
        textViewHits?.text = "$HITS $hits"
        score += 2 * time
    }

    private fun secondButtonWrong(){
        buttonBefore?.setBackgroundResource(R.color.colorPrimaryDark)
        buttonBefore?.isClickable = true
        buttonBefore = null
        textViewMistakes?.text = "$MISTAKES ${++mistakes}"
        score -= time
    }

    private fun nextLevel(){
        if(hits == 10){
            setTableNumber(tableNumber + 1)
            finish()
            startActivity(Intent(this, MathematicalTableActivity::class.java))
        }
    }

    private fun stopwatch() {
        if (countDownTimer != null) {
            countDownTimer?.cancel()
        }
        countDownTimer = object : CountDownTimer(timeMilli, 1000) {
            override fun onFinish() {
                finish()
                startActivity(Intent(this@MathematicalTableActivity, MainActivity::class.java))
            }
            override fun onTick(millisUntilFinished: Long) {
                textViewStopwatch?.text = time.toString()
                time--
            }
        }
        countDownTimer?.start()
    }

    private fun initializeTextView(){
        textViewHits = findViewById(R.id.textViewHits)
        textViewMistakes = findViewById(R.id.textViewMistakes)
        textViewScore = findViewById(R.id.textViewScore)
        textViewStopwatch = findViewById(R.id.textViewStopwatch)

        textViewScore?.text = "$score"
        textViewMistakes?.text = "$MISTAKES $mistakes"
        textViewHits?.text = "$HITS $hits"
    }

    private fun initializeButtonOnAction(){
        initializeButtonOnActionColunmLeft()
        initializeButtonOnActionColunmRight()
    }

    private fun initializeButtonOnActionColunmLeft(){
        for(button in buttonsColunmLeft){
            button!!.setOnClickListener {
                clickButton(button!!)
            }
        }
    }

    private fun initializeButtonOnActionColunmRight(){
        for(button in buttonsColunmRight){
            button!!.setOnClickListener {
                clickButton(button!!)
            }
        }
    }

    private fun initializeButtonColunmLeft(){
        buttonsColunmLeft = mutableListOf(
            findViewById(R.id.buttonTable01),
            findViewById(R.id.buttonTable02),
            findViewById(R.id.buttonTable03),
            findViewById(R.id.buttonTable04),
            findViewById(R.id.buttonTable05),
            findViewById(R.id.buttonTable06),
            findViewById(R.id.buttonTable07),
            findViewById(R.id.buttonTable08),
            findViewById(R.id.buttonTable09),
            findViewById(R.id.buttonTable10))
    }
    
    private fun initializeButtonColunmRight(){

        buttonsColunmRight = mutableListOf(
            findViewById(R.id.buttonTable11),
            findViewById(R.id.buttonTable12),
            findViewById(R.id.buttonTable13),
            findViewById(R.id.buttonTable14),
            findViewById(R.id.buttonTable15),
            findViewById(R.id.buttonTable16),
            findViewById(R.id.buttonTable17),
            findViewById(R.id.buttonTable18),
            findViewById(R.id.buttonTable19),
            findViewById(R.id.buttonTable20))
    }

    override fun onBackPressed() {
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun finish(){
        countDownTimer?.cancel()
        super.finish()
    }
}