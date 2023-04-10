package com.example.cocktailworld.data.repository

import com.example.cocktailworld.data.model.drinks.Drink

interface Repository {

    suspend fun getAlcoholic(): Drink

    suspend fun getNonAlcoholic(): Drink
}