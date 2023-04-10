package com.example.cocktailworld.data.remote

import com.example.cocktailworld.data.model.drinks.AllDrinks
import com.example.cocktailworld.data.model.drinks.Drink
import retrofit2.http.GET

interface ApiRequest {

    @GET(ApiDetails.ALCOHOLIC_URL)
    suspend fun getAlcoholic() : AllDrinks

    @GET(ApiDetails.NON_ALCOHOLIC_URL)
    suspend fun getNonAlcoholic() : AllDrinks
}