package com.example.androiddata.data

import retrofit2.Response
import retrofit2.http.GET

interface MonsterService {
    @GET("/feed/monster_data.json")
    suspend fun getMonsterData(): Response<List<Monster>>
}