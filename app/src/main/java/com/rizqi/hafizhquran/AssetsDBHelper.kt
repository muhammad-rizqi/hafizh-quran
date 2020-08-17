package com.rizqi.hafizhquran

import android.content.Context
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class AssetsDBHelper(private val context: Context) {

    companion object {

        private val DB_NAME = "quran.db"
    }

    fun openDatabase() {
        val dbFile = context.getDatabasePath(DB_NAME)


        if (!dbFile.exists()) {
            try {
                val checkDB = context.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null)
                checkDB?.close()
                copyDatabase(dbFile)
            } catch (e: IOException) {
                throw RuntimeException("Error creating source database", e)
            }

        }
    }

    private fun copyDatabase(dbFile: File) {
        try {
            val inputStream = context.assets.open(DB_NAME)
            val os = FileOutputStream(dbFile)

            val buffer = ByteArray(1024)
            while (inputStream.read(buffer) > 0) {
                os.write(buffer)
                Log.d("#DB", "writing>>")
            }

            os.flush()
            os.close()
            inputStream.close()
            Log.d("#DB", "completed..")
        } catch (throwable: Throwable) {
        }
    }
}