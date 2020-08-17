package com.rizqi.hafizhquran.model

import android.os.Parcelable
import androidx.room.*
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "quran_text")
@Parcelize
data class Aya(
    @ColumnInfo(name = "sura")
    var sura: Int?,

    @ColumnInfo(name = "aya")
    var aya: Int?,

    @PrimaryKey
    @ColumnInfo(name = "index")
    var index: Int?,

    @ColumnInfo(name = "text")
    var text: String?
) : Parcelable

@Entity(tableName = "id_indonesian")
@Parcelize
data class Indo(
    @ColumnInfo(name = "sura")
    var sura: Int?,

    @ColumnInfo(name = "aya")
    var aya: Int?,

    @PrimaryKey
    @ColumnInfo(name = "index")
    var index: Int?,

    @ColumnInfo(name = "text")
    var text: String?
) : Parcelable

data class Translate(
    @Embedded val aya: Aya,
    @Relation(
        parentColumn = "index",
        entityColumn = "index"
    )
    val indo: Indo
)

@Parcelize
data class Translated(
    var sura: Int?,
    var aya: Int?,
    var index: Int?,
    var text: String?,
    var translated: String?
) : Parcelable
