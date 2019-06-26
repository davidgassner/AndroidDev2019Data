package com.example.androiddata.ui.shared

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.androiddata.data.Monster
import com.example.androiddata.data.MonsterRepository

class SharedViewModel(app: Application) : AndroidViewModel(app) {
    private val dataRepo = MonsterRepository(app)
    val monsterData = dataRepo.monsterData

    val selectedMonster = MutableLiveData<Monster>()

    fun refreshData() {
        dataRepo.refreshData()
    }

}
