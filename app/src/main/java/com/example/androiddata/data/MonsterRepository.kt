package com.example.androiddata.data

import android.content.Context
import com.example.androiddata.utilities.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class MonsterRepository {

    private val listType = Types.newParameterizedType(
        List::class.java, Monster::class.java
    )

    fun getMonsterData(context: Context): List<Monster> {
        val text = FileHelper.getTextFromAssets(context, "monster_data.json")
        val moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<List<Monster>> =
            moshi.adapter(listType)
        return adapter.fromJson(text) ?: emptyList()
    }
}