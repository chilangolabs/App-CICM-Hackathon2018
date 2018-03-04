package com.chilangolabs.hackcicm.activitys

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chilangolabs.hackcicm.R
import com.chilangolabs.hackcicm.adapters.AdapterReportsNews
import com.chilangolabs.hackcicm.adapters.OnRCListener
import com.chilangolabs.hackcicm.entitys.ItemReportsNews
import com.chilangolabs.hackcicm.utils.loge
import kotlinx.android.synthetic.main.activity_reports.*

class ReportsActivity : AppCompatActivity() {

    private val listenerRc: OnRCListener = object : OnRCListener {
        override fun onClick(position: Int, view: View?) {
            loge("Click On $position")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports)

        intent?.extras?.let { bundle ->
            val title = bundle.getString("title")
            txtReportTitle?.text = title
        }

        val data = mutableListOf<ItemReportsNews>()
        data.add(ItemReportsNews("Edificio dañado", "Estatus activo", "http://lorempixel.com/300/300/city/1"))
        data.add(ItemReportsNews("Edificio dañado", "Estatus activo", "http://lorempixel.com/300/300/city/2"))
        data.add(ItemReportsNews("Edificio dañado", "Estatus activo", "http://lorempixel.com/300/300/city/3"))
        data.add(ItemReportsNews("Edificio dañado", "Estatus activo", "http://lorempixel.com/300/300/city/4"))
        data.add(ItemReportsNews("Edificio dañado", "Estatus activo", "http://lorempixel.com/300/300/city/5"))
        data.add(ItemReportsNews("Edificio dañado", "Estatus activo", "http://lorempixel.com/300/300/city/6"))
        data.add(ItemReportsNews("Edificio dañado", "Estatus activo", "http://lorempixel.com/300/300/city/7"))
        data.add(ItemReportsNews("Edificio dañado", "Estatus activo", "http://lorempixel.com/300/300/city/8"))

        val adapter = AdapterReportsNews(data, listenerRc)

        rcReportes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcReportes.setHasFixedSize(true)
        rcReportes.adapter = adapter

        imgReportBack?.setOnClickListener { finish() }

    }

}
