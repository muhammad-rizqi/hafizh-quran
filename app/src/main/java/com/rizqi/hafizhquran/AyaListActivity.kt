package com.rizqi.hafizhquran

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rizqi.hafizhquran.adapter.AyaFragmentAdapter
import kotlinx.android.synthetic.main.activity_aya_list.*

class AyaListActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_SURA_INDEX = "extra_sura_index"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aya_list)

        val sectionsPagerAdapter = AyaFragmentAdapter(this, supportFragmentManager)

        pager.adapter = sectionsPagerAdapter
        val page = intent.getIntExtra(EXTRA_SURA_INDEX, 0)
        pager.currentItem = page - 1
    }
}
