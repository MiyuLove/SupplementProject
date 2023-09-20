package com.exercise.supplementalram.ViewUtilBox

import android.util.TypedValue
import android.widget.TextView
import com.exercise.supplementalram.R

class TextUtil {
    companion object{
        fun TextView.textUtil(
            fontFamily: Int = R.font.base_font,
            autoSizeMinTextSize: Int = 10,
            autoSizeMaxTextSize: Int = 40,
            autoSizeStepGranularity:Int = 2,
            typedValue: Int = TypedValue.COMPLEX_UNIT_SP
        ){
            this.setAutoSizeTextTypeUniformWithConfiguration(
                autoSizeMinTextSize,
                autoSizeMaxTextSize,
                autoSizeStepGranularity,
                typedValue
            )
        }
    }

    private fun setFontFamily(){

    }
}