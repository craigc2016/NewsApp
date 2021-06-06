package com.example.newsapiclient.data.db

import androidx.room.TypeConverter
import com.example.newsapiclient.data.model.Source


/**
 *Created by Craig Cormack on 26/05/2021.
 */
class Converters {

    @TypeConverter
    fun fromSource(source: Source) : String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String) : Source {
        return Source(name,name)
    }
}