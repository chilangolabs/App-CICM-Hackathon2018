package com.chilangolabs.hackcicm.activitys

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.chilangolabs.hackcicm.R
import com.chilangolabs.hackcicm.adapters.AdapterMainList
import com.chilangolabs.hackcicm.adapters.OnRCListener
import com.chilangolabs.hackcicm.entitys.ItemMain
import com.chilangolabs.hackcicm.utils.loge
import kotlinx.android.synthetic.main.activity_main_list.*

class MainListActivity : AppCompatActivity() {

    private val listenerRc: OnRCListener = object : OnRCListener {
        override fun onClick(position: Int, view: View?) {
            loge("Click On $position")
            selectWay(position, view)
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

    private fun selectWay(position: Int, title: View?) {
        when (position) {
            0 -> {
                val intent = Intent(this, ReportsActivity::class.java)
                intent.putExtra("title", "Mis Reportes")
                val p1: Pair<View, String> = Pair.create(title as View, getString(R.string.report_title_transitionname))
                val options: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1)
                startActivity(intent, options.toBundle())
            }
            1 -> {
                val intent = Intent(this, ReportsActivity::class.java)
                intent.putExtra("title", "Reporte Vecinos")
                val p1: Pair<View, String> = Pair.create(title as View, getString(R.string.report_title_transitionname))
                val options: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1)
                startActivity(intent, options.toBundle())
            }
            2 -> {
                val intent = Intent(this, ReportsActivity::class.java)
                intent.putExtra("title", "Noticias")
                val p1: Pair<View, String> = Pair.create(title as View, getString(R.string.report_title_transitionname))
                val options: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1)
                startActivity(intent, options.toBundle())
            }
        }
    }

}
