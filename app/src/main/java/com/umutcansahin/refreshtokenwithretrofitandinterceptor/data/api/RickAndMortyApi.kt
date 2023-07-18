package com.umutcansahin.refreshtokenwithretrofitandinterceptor.data.api

import com.umutcansahin.refreshtokenwithretrofitandinterceptor.data.dto.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApi {

    @GET("character/{characterId}")
    suspend fun getCharacterById(
        @Path("characterId") characterId: Int = 1
    ): CharacterResponse
}