package com.mainduelo.minigamemathematicaltable

import android.content.Context
import com.mainduelo.minigamemathematicaltable.component.view.ButtonTable
import org.junit.Test
import org.junit.Assert.*

class ManipulationColunmTest {

    @Test
    fun buttonsColunmLeftTest(){
        var buttonsColunmLeft : MutableList<ButtonTable?> = mutableListOf()
        var c : Context? =  null
        buttonsColunmLeft = mutableListOf(
            ButtonTable(c),
            ButtonTable(c),
            ButtonTable(c),
            ButtonTable(c),
            ButtonTable(c),
            ButtonTable(c),
            ButtonTable(c),
            ButtonTable(c),
            ButtonTable(c),
            ButtonTable(c))
        buttonsColunmLeft = ManipulationColunm(buttonsColunmLeft).setLeftColunm(1).buttons
        assertEqualsButtonNumber(buttonsColunmLeft)
    }

    @Test
    fun buttonsColunmRightTest(){
        var buttonsColunmRight : MutableList<ButtonTable?> = mutableListOf()
        var c : Context? =  null
        buttonsColunmRight = mutableListOf(
            ButtonTable(c),
            ButtonTable(c),
            ButtonTable(c),
            ButtonTable(c),
            ButtonTable(c),
            ButtonTable(c),
            ButtonTable(c),
            ButtonTable(c),
            ButtonTable(c),
            ButtonTable(c))
        buttonsColunmRight = ManipulationColunm(buttonsColunmRight).setRightColunm(1).buttons
        assertNotEqualsButtonNumber(buttonsColunmRight)
    }

    fun assertEqualsButtonNumber(b :  MutableList<ButtonTable?>){
        var increment : Int = 0
        for(s in b)
            assertEquals(++increment, s?.number)
    }

    fun assertNotEqualsButtonNumber(b :  MutableList<ButtonTable?>){
        var increment : Int = 0
        var different : Int = 0
        for(s in b)
            if(!s?.number!!.equals(++increment))
                different++
        assertTrue(different > 5)
    }
}
