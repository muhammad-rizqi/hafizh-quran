package com.rizqi.hafizhquran.model

import com.google.gson.annotations.SerializedName

data class Suras(
    val sura: ArrayList<MetaSura>
)

data class MetaSura(
    @SerializedName("-index")
    var index: Int,

    @SerializedName("-ayas")
    var ayas: Int,

    @SerializedName("-start")
    var start: Int,

    @SerializedName("-name")
    var name: String,

    @SerializedName("-tname")
    var tname: String,

    @SerializedName("-ename")
    var ename: String,

    @SerializedName("-type")
    var type: String,

    @SerializedName("-order")
    var order: Int,

    @SerializedName("-rukus")
    var rukus: Int
)