package com.example.androiddata.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.androiddata.LOG_TAG
import com.example.androiddata.data.Monster
import com.example.androiddata.utilities.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val listType = Types.newParameterizedType(
        List::class.java, Monster::class.java
    )

    init {
//        val text = FileHelper.getTextFromResources(app, R.raw.monster_data)
        val text = FileHelper.getTextFromAssets(app, "monster_data.json")
        parseText(text)
    }

    fun parseText(text: String) {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val adapter: JsonAdapter<List<Monster>> =
            moshi.adapter(listType)
        val monsterData = adapter.fromJson(text)

        for (monster in monsterData ?: emptyList()) {
            Log.i(LOG_TAG,
                "${monster.name} (\$${monster.price})")
        }
    }
}
