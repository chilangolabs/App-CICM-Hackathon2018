package com.chilangolabs.hackcicm.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chilangolabs.hackcicm.R
import com.chilangolabs.hackcicm.entitys.ItemMain
import kotlinx.android.synthetic.main.item_tile_main.view.*

/**
 * @author gorrotowi
 * @since 04/03/18.
 */
class AdapterMainList(val data: List<ItemMain>, listener: OnRCListener) : RecyclerView.Adapter<AdapterMainList.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
            VH(LayoutInflater.from(parent.context).inflate(R.layout.item_tile_main, parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindView(data[position])
    }

    override fun getItemCount(): Int = data.size

    class VH(private val v: View?) : RecyclerView.ViewHolder(v) {
        fun bindView(item: ItemMain) {
            v?.let {
                with(it) {
                    txtItemMainTitle.text = item.Title
                    txtItemMainNumItems.text = "${item.numItems}\nItems"
                }
            }
        }
    }
}

interface OnRCListener {
    fun OnClick(position: Int)
}