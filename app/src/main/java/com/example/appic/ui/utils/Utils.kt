package com.example.appic.ui.utils

import android.content.Context
import android.content.res.AssetManager
import java.io.IOException
import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    @Throws(IOException::class)
    fun assetJSONFile(filename: String?, context: Context): String? {
        val manager: AssetManager = context.assets
        val file: InputStream = manager.open(filename!!)
        val formArray = ByteArray(file.available())
        file.read(formArray)
        file.close()
        return String(formArray)
    }
}