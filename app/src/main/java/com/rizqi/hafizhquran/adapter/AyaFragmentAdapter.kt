package com.rizqi.hafizhquran.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rizqi.hafizhquran.fragment.AyaFragment

class AyaFragmentAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return AyaFragment.newInstance(position + 1)
    }

    override fun getCount(): Int = 114

}