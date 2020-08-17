package com.rizqi.hafizhquran.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rizqi.hafizhquran.R
import com.rizqi.hafizhquran.model.Aya
import kotlinx.android.synthetic.main.item_aya.view.*

class AyaListAdapter(private var listAya: ArrayList<Aya>) :
    RecyclerView.Adapter<AyaListAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(aya: Aya) {
            with(itemView) {
                tv_aya.text = aya.text
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_aya, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listAya.size

    override fun onBindViewHolder(holder: AyaListAdapter.ListViewHolder, position: Int) {
        val aya = listAya[position]
        holder.bind(aya)
    }
}