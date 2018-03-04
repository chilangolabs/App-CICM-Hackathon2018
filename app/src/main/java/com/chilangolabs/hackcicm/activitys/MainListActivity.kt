package com.chilangolabs.hackcicm.activitys

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.chilangolabs.hackcicm.R
import com.chilangolabs.hackcicm.adapters.AdapterMainList
import com.chilangolabs.hackcicm.adapters.OnRCListener
import com.chilangolabs.hackcicm.entitys.ItemMain
import com.chilangolabs.hackcicm.utils.loge
import kotlinx.android.synthetic.main.activity_main_list.*

class MainListActivity : AppCompatActivity() {

    private val listenerRc: OnRCListener = object : OnRCListener {
        override fun onClick(position: Int) {
            loge("Click On $position")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)

        val data = mutableListOf<ItemMain>()
        data.add(ItemMain("Mis Reportes", "03"))
        data.add(ItemMain("Reporte Vecinos", "03"))
        data.add(ItemMain("Noticias", "03"))
        data.add(ItemMain("Mi Kalpoli", "03"))
        data.add(ItemMain("Agregar\nreporte", "03", false))

        val adapter = AdapterMainList(data, listenerRc)

        rcMainList.layoutManager = GridLayoutManager(this, 2)
        rcMainList.setHasFixedSize(true)
        rcMainList.adapter = adapter

    }
}
