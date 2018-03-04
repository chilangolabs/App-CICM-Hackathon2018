package com.chilangolabs.hackcicm

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.chilangolabs.hackcicm.activitys.RegisterFormActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        btnLogin?.setOnClickListener {

            val intent = Intent(this, RegisterFormActivity::class.java)
            val p1: Pair<View, String> = Pair.create(txtLoginTitle as View, getString(R.string.app_name))
            val p2: Pair<View, String> = Pair.create(cardLoginForm as View, getString(R.string.containerForm))
            val options: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1, p2)

            startActivity(intent, options.toBundle())
        }
    }
}
