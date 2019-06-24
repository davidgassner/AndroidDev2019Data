package com.example.androiddata.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.androiddata.LOG_TAG
import com.example.androiddata.data.MonsterRepository

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val dataRepo = MonsterRepository()

    init {

        val monsterData = dataRepo.getMonsterData(app)
        for (monster in monsterData) {
            Log.i(
                LOG_TAG,
                "${monster.monsterName} (\$${monster.price})"
            )
        }

    }

}
