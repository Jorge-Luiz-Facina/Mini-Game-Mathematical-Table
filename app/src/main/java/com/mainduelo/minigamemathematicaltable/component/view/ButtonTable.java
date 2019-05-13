package com.mainduelo.minigamemathematicaltable.component.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

@SuppressLint("AppCompatCustomView")
public class ButtonTable extends Button {

    private int number;

    public ButtonTable(Context context) {
        super(context);
    }

    public ButtonTable(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ButtonTable(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ButtonTable setNumber(int number){
            this.number = number;
        return  this;
    }

    public int getNumber(){
        return number;
    }
}
