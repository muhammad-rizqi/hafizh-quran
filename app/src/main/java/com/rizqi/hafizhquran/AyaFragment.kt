package com.rizqi.hafizhquran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizqi.hafizhquran.adapter.TranslateAdapter
import com.rizqi.hafizhquran.viewmodel.AyaViewModel
import kotlinx.android.synthetic.main.fragment_aya.*

class AyaFragment : Fragment() {
    lateinit var ayaViewModel: AyaViewModel
    lateinit var adapter: TranslateAdapter

    companion object {
        private val ARG_SECTION_NUMBER = "section_number"
        fun newInstance(index: Int): AyaFragment {
            val fragment = AyaFragment()
            val bundle = Bundle()
            bundle.putInt(ARG_SECTION_NUMBER, index)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aya, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var index = 1

        if (arguments != null) {
            index = arguments?.getInt(ARG_SECTION_NUMBER, 0) as Int
        }

        ayaViewModel = ViewModelProvider(this).get(AyaViewModel::class.java)
        ayaViewModel.getTranslateBySura(index)
        activity?.let {
            ayaViewModel.quran_translate_sura.observe(it, Observer { items ->
                if (items != null) {
                    val divider =
                        DividerItemDecoration(rv_list.context, DividerItemDecoration.VERTICAL)
                    context?.getDrawable(R.drawable.divider)?.let { divider.setDrawable(it) }

                    adapter = TranslateAdapter(items)
                    rv_list.layoutManager = LinearLayoutManager(context)
                    rv_list.addItemDecoration(divider)
                    rv_list.adapter = adapter
                }
            })
        }
    }

}