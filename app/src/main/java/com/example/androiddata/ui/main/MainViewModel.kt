package com.example.androiddata.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.androiddata.LOG_TAG
import com.example.androiddata.utilities.FileHelper

class MainViewModel(app: Application) : AndroidViewModel(app) {

    init {
//        val text = FileHelper.getTextFromResources(app, R.raw.monster_data)
        val text = FileHelper.getTextFromAssets(app, "monster_data.json")
        Log.i(LOG_TAG, text)
    }
}
