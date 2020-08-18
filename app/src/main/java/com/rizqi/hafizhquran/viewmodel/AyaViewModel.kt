package com.rizqi.hafizhquran.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rizqi.hafizhquran.db.AyaRoomDatabase
import com.rizqi.hafizhquran.model.Aya
import com.rizqi.hafizhquran.model.Translated
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AyaViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext = application

    private val quranAya = MutableLiveData<Aya>()
    private val quranSura = MutableLiveData<ArrayList<Aya>>()
    val quranTranslateSura = MutableLiveData<ArrayList<Translated>>()

    private val database = AyaRoomDatabase.getDatabase(mContext)
    private val dao = database.getUserDao()

    fun getAyaBySura(sura: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val ayaList = ArrayList(dao.getSura(sura))
                    quranSura.postValue(ayaList)
                } catch (throwable: Throwable) {
                    getError(throwable)
                }
            }
        }
    }

    fun getTranslateBySura(sura: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val ayaList = ArrayList(dao.getTranslate(sura))
                    val result = ArrayList<Translated>()
                    for (i in ayaList.indices) {
                        val translated = Translated(
                            ayaList[i].aya.sura,
                            ayaList[i].aya.aya,
                            ayaList[i].aya.index,
                            ayaList[i].aya.text,
                            ayaList[i].indo.text
                        )
                        result.add(translated)
                    }
                    quranTranslateSura.postValue(result)
                } catch (throwable: Throwable) {
                    getError(throwable)
                }
            }
        }
    }

    fun getAya(aya: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = dao.getByAya(aya)
                    quranAya.postValue(result)
                } catch (throwable: Throwable) {
                    getError(throwable)
                }
            }
        }
    }


    private fun getError(throwable: Throwable) {
        Log.d("error", "${throwable.message}")
    }

}