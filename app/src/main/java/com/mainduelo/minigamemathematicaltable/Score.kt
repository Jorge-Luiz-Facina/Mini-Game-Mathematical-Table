package com.mainduelo.minigamemathematicaltable

class Score{
    companion object {
        val instance = Score()
    }

    var punctuation : MutableList<Int> = mutableListOf(0 ,0, 0, 0, 0, 0, 0, 0, 0, 0)

    fun upgradePunctuation(value : Int, index : Int){
        if(punctuation[index] < value)
            punctuation[index] = value
    }

    fun getTotal(): Int{
        var total : Int = 0
        for(value in  punctuation)
            total+= value
        return total
    }
}