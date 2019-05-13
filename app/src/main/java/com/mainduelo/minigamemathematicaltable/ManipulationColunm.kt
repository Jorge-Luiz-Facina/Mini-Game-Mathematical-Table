package com.mainduelo.minigamemathematicaltable

import com.mainduelo.minigamemathematicaltable.component.view.ButtonTable

class ManipulationColunm(val buttons : MutableList<ButtonTable?> = mutableListOf()){

    fun setLeftColunm(number : Int) : ManipulationColunm {
        var increment : Int = 0
        for (button in buttons){
            button!!
                .setNumber(number * ++increment)
                .text = "$number × $increment"
        }
        return this
    }

    fun setRightColunm(number : Int) : ManipulationColunm {
        var numbers = getListRightColunm(number)
        var increment : Int = 0
        for (button in buttons){
            button!!
                .setNumber(numbers[increment])
                .text = numbers[increment++].toString()
        }
        return this
    }

    fun getListRightColunm(numberMultiplier : Int) : MutableList<Int>{
        var numbers : MutableList<Int> = mutableListOf()
        for (number in 1..10)
            numbers.add(numberMultiplier * number)
        numbers.shuffle()
        return numbers
    }
}