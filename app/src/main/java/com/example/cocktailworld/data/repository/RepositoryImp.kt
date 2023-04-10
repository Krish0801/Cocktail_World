package com.example.cocktailworld.data.repository

import com.example.cocktailworld.data.remote.ApiRequest
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    val apiRequest: ApiRequest
): Repository {
    override suspend fun getAlcoholic() = apiRequest.getAlcoholic()

    override suspend fun getNonAlcoholic() = apiRequest.getNonAlcoholic()


}