package com.chilangolabs.hackcicm

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.view.View
import com.chilangolabs.hackcicm.activitys.BaseActivity
import com.chilangolabs.hackcicm.activitys.MainListActivity
import com.chilangolabs.hackcicm.activitys.RegisterFormActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setStatusBarWhite(window)
    }

    override fun onResume() {
        super.onResume()

        btnLogin?.setOnClickListener {
            startActivity<MainListActivity>()
        }

        txtLoginNoRegister?.setOnClickListener {
            startActivity<MainListActivity>()
        }

        txtLoginRegister?.setOnClickListener {
            val intent = Intent(this, RegisterFormActivity::class.java)
            val p1: Pair<View, String> = Pair.create(txtLoginTitle as View, getString(R.string.app_name))
            val p2: Pair<View, String> = Pair.create(cardLoginForm as View, getString(R.string.containerForm))
            val p3: Pair<View, String> = Pair.create(imgLoginLogo as View, "imagetransitionname")
            val options: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1, p2, p3)

            startActivity(intent, options.toBundle())
        }
    }
}
