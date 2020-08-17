package com.rizqi.hafizhquran.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rizqi.hafizhquran.R
import com.rizqi.hafizhquran.model.Translated
import kotlinx.android.synthetic.main.item_translated.view.*

class TranslateAdapter(private var listAya: ArrayList<Translated>) :
    RecyclerView.Adapter<TranslateAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(aya: Translated) {
            with(itemView) {
                tv_aya.text = aya.text
                tv_translated.text = """${aya.aya}. ${aya.translated}"""

            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_translated, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listAya.size

    override fun onBindViewHolder(holder: TranslateAdapter.ListViewHolder, position: Int) {
        val aya = listAya[position]
        holder.bind(aya)
    }
}