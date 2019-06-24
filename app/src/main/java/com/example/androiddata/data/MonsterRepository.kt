package com.example.androiddata.data

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.androiddata.utilities.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class MonsterRepository(val app: Application) {

    val monsterData = MutableLiveData<List<Monster>>()

    private val listType = Types.newParameterizedType(
        List::class.java, Monster::class.java
    )

    init {
        getMonsterData()
    }

    fun getMonsterData() {
        val text = FileHelper.getTextFromAssets(app, "monster_data.json")
        val moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<List<Monster>> =
            moshi.adapter(listType)
        monsterData.value = adapter.fromJson(text) ?: emptyList()
    }
}