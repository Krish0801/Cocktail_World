package com.example.cocktailworld.data.remote

import com.example.cocktailworld.data.model.drinks.Drink
import retrofit2.http.GET

interface ApiRequest {

    @GET(ApiDetails.ALCOHOLIC_URL)
    suspend fun getAlcoholic() : Drink

    @GET(ApiDetails.NON_ALCOHOLIC_URL)
    suspend fun getNonAlcoholic() : Drink
}