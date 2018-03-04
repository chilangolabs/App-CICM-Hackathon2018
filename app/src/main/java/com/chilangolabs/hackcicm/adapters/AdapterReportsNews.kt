package com.chilangolabs.hackcicm.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.chilangolabs.hackcicm.R
import com.chilangolabs.hackcicm.entitys.ItemReportsNews
import kotlinx.android.synthetic.main.item_reports_news.view.*

/**
 * @author gorrotowi
 * @since 04/03/18.
 */
class AdapterReportsNews(val data: List<ItemReportsNews>, private val listener: OnRCListener) : RecyclerView.Adapter<AdapterReportsNews.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
            VH(LayoutInflater.from(parent.context).inflate(R.layout.item_reports_news, parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindView(data[position])
        holder.itemView?.setOnClickListener {
            listener.onClick(position)
        }
    }

    override fun getItemCount(): Int = data.size

    class VH(private val v: View?) : RecyclerView.ViewHolder(v) {
        fun bindView(item: ItemReportsNews) {
            v?.let {
                with(it) {
                    txtItemReportsTitle.text = item.title
                    txtItemReportsStatus.text = item.status
                    Glide.with(context).load("https://loremflickr.com/320/240").into(imgItemReports)
                }
            }
        }
    }

}