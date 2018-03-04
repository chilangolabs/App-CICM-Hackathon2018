package com.chilangolabs.hackcicm.customelements

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

object FontStyle {

    fun initStyle(ctx: Context, v: View) {
        val tp = Typeface.createFromAsset(ctx.assets, "fonts/Montserrat-Regular.otf")
        setTypeface(tp, v)
    }

    fun initStyle(ctx: Context, font: Int, v: View) {
        val tp: Typeface = when (font) {
            0 -> {
                Typeface.createFromAsset(ctx.assets, "fonts/Montserrat-Black.otf")
            }
            1 -> {
                Typeface.createFromAsset(ctx.assets, "fonts/Montserrat-Bold.otf")
            }
            2 -> {
                Typeface.createFromAsset(ctx.assets, "fonts/Montserrat-ExtraBold.otf")
            }
            3 -> {
                Typeface.createFromAsset(ctx.assets, "fonts/Montserrat-Hairline.otf")
            }
            4 -> {
                Typeface.createFromAsset(ctx.assets, "fonts/Montserrat-Light.otf")
            }
            5 -> {
                Typeface.createFromAsset(ctx.assets, "fonts/Montserrat-Regular.otf")
            }
            6 -> {
                Typeface.createFromAsset(ctx.assets, "fonts/Montserrat-SemiBold.otf")
            }
            7 -> {
                Typeface.createFromAsset(ctx.assets, "fonts/Montserrat-UltraLight.otf")
            }
            else -> {
                Typeface.createFromAsset(ctx.assets, "fonts/Montserrat-Regular.otf")
            }
        }
        setTypeface(tp, v)
    }

    fun setTypeface(typeface: Typeface, v: View) {
        when (v) {
            is TextView -> v.typeface = typeface
            is EditText -> v.typeface = typeface
            is Button -> v.typeface = typeface
        }
    }
}
