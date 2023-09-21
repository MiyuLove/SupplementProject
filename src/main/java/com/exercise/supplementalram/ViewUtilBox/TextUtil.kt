package com.exercise.supplementalram.ViewUtilBox

import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import com.exercise.supplementalram.R

class TextUtil {
    companion object{
        fun TextView.textUtil(
            text : String = "",
            fontFamily: Int = R.font.base_font,
            autoSizeMinTextSize: Int = 10,
            autoSizeMaxTextSize: Int = 40,
            autoSizeStepGranularity:Int = 2,
            gravity: Int = Gravity.CENTER,
            typedValue: Int = TypedValue.COMPLEX_UNIT_SP
        ){
            this.text = text
            this.typeface = resources.getFont(fontFamily)
            this.gravity = gravity
            setAutoTextSize(this,autoSizeMinTextSize,autoSizeMaxTextSize,autoSizeStepGranularity,typedValue)
        }

        private fun setAutoTextSize(
            textView:TextView,
            autoSizeMinTextSize: Int,
            autoSizeMaxTextSize: Int,
            autoSizeStepGranularity:Int,
            typedValue: Int
        ){
            textView.setAutoSizeTextTypeUniformWithConfiguration(
                autoSizeMinTextSize,
                autoSizeMaxTextSize,
                autoSizeStepGranularity,
                typedValue
            )
        }
    }
}