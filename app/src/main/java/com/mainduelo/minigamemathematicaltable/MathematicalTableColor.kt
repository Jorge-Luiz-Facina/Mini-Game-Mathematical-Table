package com.mainduelo.minigamemathematicaltable

import android.content.Context
import android.support.v4.content.ContextCompat

class MathematicalTableColor{
    companion object {
        val instance = MathematicalTableColor()
    }

    fun getColorButton(indice : Int, context: Context):Int = when(indice){
        1 -> ContextCompat.getColor(context, R.color.hit1)
        2 -> ContextCompat.getColor(context, R.color.hit2)
        3 -> ContextCompat.getColor(context, R.color.hit3)
        4 -> ContextCompat.getColor(context, R.color.hit4)
        5 -> ContextCompat.getColor(context, R.color.hit5)
        6 -> ContextCompat.getColor(context, R.color.hit6)
        7 -> ContextCompat.getColor(context, R.color.hit7)
        8 -> ContextCompat.getColor(context, R.color.hit8)
        9 -> ContextCompat.getColor(context, R.color.hit9)
        10 -> ContextCompat.getColor(context, R.color.hit10)
        else -> ContextCompat.getColor(context, R.color.black)
    }
}