package com.rizqi.hafizhquran.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rizqi.hafizhquran.AyaListActivity
import com.rizqi.hafizhquran.R
import com.rizqi.hafizhquran.model.MetaSura
import kotlinx.android.synthetic.main.item_sura.view.*
import java.util.*

class SuraListAdapter(private var listSuras: ArrayList<MetaSura>) :
    RecyclerView.Adapter<SuraListAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(sura: MetaSura) {
            with(itemView) {
                tv_id_sura.text = sura.index.toString()
                tv_sura_name.text = sura.tname
                tv_name_arabic.text = sura.name
                tv_sura_translate.text = sura.ename

                setOnClickListener {
                    val intent = Intent(context, AyaListActivity::class.java)
                    intent.putExtra(AyaListActivity.EXTRA_SURA_INDEX, sura.index)
                    context.startActivity(intent)
                }

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_sura, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listSuras.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val sura = listSuras[position]
        holder.bind(sura)
    }
}