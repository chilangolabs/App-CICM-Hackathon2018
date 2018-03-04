package com.chilangolabs.hackcicm.activitys

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chilangolabs.hackcicm.R
import kotlinx.android.synthetic.main.activity_register_form.*
import org.jetbrains.anko.startActivity

class RegisterFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_form)

        btnRegister?.setOnClickListener {
            startActivity<VerifyIDActivity>()
        }
    }
}
