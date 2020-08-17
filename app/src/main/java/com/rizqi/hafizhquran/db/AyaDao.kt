package com.rizqi.hafizhquran.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.rizqi.hafizhquran.model.Aya
import com.rizqi.hafizhquran.model.Translate

@Dao
interface AyaDao {

    @Query("SELECT * FROM quran_text WHERE aya = :aya ")
    fun getByAya(aya: Int): Aya

    @Query("SELECT * FROM quran_text WHERE sura = :sura ")
    fun getSura(sura: Int): List<Aya>

    @Transaction
    @Query("SELECT * FROM quran_text WHERE sura = :sura")
    fun getTranslate(sura: Int): List<Translate>

}