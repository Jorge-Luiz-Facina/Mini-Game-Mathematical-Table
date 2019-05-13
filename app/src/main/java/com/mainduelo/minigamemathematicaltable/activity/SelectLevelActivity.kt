package com.mainduelo.minigamemathematicaltable.activity
import android.content.Intent
import android.widget.ArrayAdapter
import android.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list_level.*
import com.mainduelo.minigamemathematicaltable.R.array.*


class SelectLevelActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(com.mainduelo.minigamemathematicaltable.R.layout.activity_list_level)

         val colorArrays = resources.getStringArray(Levels)
         var arrayAdapter = ArrayAdapter(this, R.layout.simple_list_item_1, colorArrays)

         listLevel.adapter = arrayAdapter
         listLevel.setOnItemClickListener { adapterView, view, position: Int, id: Long ->
             MathematicalTableActivity.setTableNumber(position + 1)
             startActivity(Intent(this, MathematicalTableActivity::class.java))
         }
     }
}
