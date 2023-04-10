package com.example.cocktailworld.data.repository

import com.example.cocktailworld.data.model.drinks.AllDrinks

interface Repository {

    suspend fun getAlcoholic(): AllDrinks

    suspend fun getNonAlcoholic(): AllDrinks
}