package com.example.cocktailworld.ui.alcoholic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailworld.data.model.drinks.Drink
import com.example.cocktailworld.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlcoholicViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    val alcoholic = MutableLiveData<Drink>()
        fun getAlcoholic() {

            viewModelScope.launch {
                val result = repository.getAlcoholic()
                alcoholic.postValue(result)
            }

        }
}