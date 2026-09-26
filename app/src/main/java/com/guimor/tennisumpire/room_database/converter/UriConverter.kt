package com.guimor.tennisumpire.room_database.converter

import android.net.Uri
import androidx.core.net.toUri
import androidx.room.TypeConverter

class UriConverter {
    @TypeConverter
    fun toDatabase(uri: Uri?): String? {
        return uri?.toString()
    }

    @TypeConverter
    fun fromDatabase(uriString: String?): Uri? {
        return uriString?.toUri()
    }
}