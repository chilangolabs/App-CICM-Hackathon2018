package com.chilangolabs.hackcicm.customelements

import android.content.Context
import android.support.v7.widget.AppCompatEditText
import android.util.AttributeSet
import com.chilangolabs.hackcicm.R


class MontserratEditText : AppCompatEditText {
    constructor(context: Context) : super(context) {
        if (!isInEditMode) {
            FontStyle.initStyle(getContext(), this)
        }
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        if (!isInEditMode) {
            val typedArray = context.theme.obtainStyledAttributes(
                    attrs,
                    R.styleable.montserrat_font,
                    0, 0)

            try {
                val font = typedArray.getInteger(R.styleable.montserrat_font_fontM, 0)
                FontStyle.initStyle(getContext(), font, this)
            } finally {
                typedArray.recycle()
            }
        }
    }
}
