package com.example.androiddata.ui.shared

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.preference.PreferenceManager
import com.example.androiddata.data.Monster
import com.example.androiddata.data.MonsterRepository

class SharedViewModel(val app: Application) : AndroidViewModel(app) {
    private val dataRepo = MonsterRepository(app)
    val monsterData = dataRepo.monsterData

    val selectedMonster = MutableLiveData<Monster>()
    val activityTitle = MutableLiveData<String>()

    init {
        updateActivityTitle()
    }

    fun refreshData() {
        dataRepo.refreshDataFromWeb()
    }

    fun updateActivityTitle() {
        val signature =
            PreferenceManager.getDefaultSharedPreferences(app)
                .getString("signature", "Monster fan")
        activityTitle.value = "Stickers for $signature"
    }

}
