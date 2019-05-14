package com.mainduelo.minigamemathematicaltable

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.mainduelo.minigamemathematicaltable.activity.MathematicalTableActivity
import com.mainduelo.minigamemathematicaltable.component.view.ButtonTable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class MathematicalTableActivityTest {
    @Rule
    @JvmField
    var rule = ActivityTestRule (MathematicalTableActivity :: class.java )

    var buttonsColunmLeft : MutableList<ButtonTable?> = mutableListOf()
    var buttonsColunmRight : MutableList<ButtonTable?> = mutableListOf()

    @Before
    fun before(){
        initializeButtonColunmLeft()
        initializeButtonColunmRight()
    }

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.mainduelo.minigamemathematicaltable", appContext.packageName)
    }

    @Test
    fun assertEqualsButtonColunmLeftTextTest(){
        var increment : Int = 0
        for (button in buttonsColunmLeft)
            assertEquals(button?.text, "1 × ${++increment}")
    }

    @Test
    fun assertEqualsButtonColunmRightTextTest(){
        for (button in buttonsColunmRight)
            assertEquals(button?.text, button?.number.toString())
    }

    private fun initializeButtonColunmLeft(){
        buttonsColunmLeft = mutableListOf(
            rule.activity.findViewById(R.id.buttonTable01),
            rule.activity.findViewById(R.id.buttonTable02),
            rule.activity.findViewById(R.id.buttonTable03),
            rule.activity.findViewById(R.id.buttonTable04),
            rule.activity.findViewById(R.id.buttonTable05),
            rule.activity.findViewById(R.id.buttonTable06),
            rule.activity.findViewById(R.id.buttonTable07),
            rule.activity.findViewById(R.id.buttonTable08),
            rule.activity.findViewById(R.id.buttonTable09),
            rule.activity.findViewById(R.id.buttonTable10))
    }

    private fun initializeButtonColunmRight(){

        buttonsColunmRight = mutableListOf(
            rule.activity.findViewById(R.id.buttonTable11),
            rule.activity.findViewById(R.id.buttonTable12),
            rule.activity.findViewById(R.id.buttonTable13),
            rule.activity.findViewById(R.id.buttonTable14),
            rule.activity.findViewById(R.id.buttonTable15),
            rule.activity.findViewById(R.id.buttonTable16),
            rule.activity.findViewById(R.id.buttonTable17),
            rule.activity.findViewById(R.id.buttonTable18),
            rule.activity.findViewById(R.id.buttonTable19),
            rule.activity.findViewById(R.id.buttonTable20))
    }
}
