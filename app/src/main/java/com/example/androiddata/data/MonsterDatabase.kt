package com.example.androiddata.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Monster::class], version = 1, exportSchema = false)
abstract class MonsterDatabase: RoomDatabase() {

    abstract fun monsterDao(): MonsterDao

    companion object {
        @Volatile
        private var INSTANCE: MonsterDatabase? = null

        fun getDatabase(context: Context): MonsterDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MonsterDatabase::class.java,
                        "monsters.db"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}