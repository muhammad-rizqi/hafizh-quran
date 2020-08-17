package com.rizqi.hafizhquran

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.rizqi.hafizhquran.adapter.SuraListAdapter
import com.rizqi.hafizhquran.model.Suras
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var adapter: SuraListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val assetsDBHelper = AssetsDBHelper(this)
        GlobalScope.launch(Dispatchers.IO) {

            assetsDBHelper.openDatabase()
            withContext(Dispatchers.Main) {
                progressBar2.visibility = View.GONE
                setupSuraList()
            }
        }


    }

    private fun setupSuraList() {
        val listSuras = Gson().fromJson(getSuraData(), Suras::class.java)
        rv_sura_list.layoutManager = LinearLayoutManager(this)
        adapter = SuraListAdapter(listSuras.sura)
        rv_sura_list.adapter = adapter
    }


    private fun getJsonDataFromAsset(): JSONObject {
        val jsonString: String
        val jsonObject: JSONObject
        val fileName = "quran-data.json"
        jsonString = assets.open(fileName).bufferedReader().use { it.readText() }
        jsonObject = JSONObject(jsonString).getJSONObject("quran")
        return jsonObject
    }

    private fun getSuraData(): String {
        val quran = getJsonDataFromAsset()
        val suraData = quran.getJSONObject("suras") //.getJSONArray("sura")
        return suraData.toString()
    }
}