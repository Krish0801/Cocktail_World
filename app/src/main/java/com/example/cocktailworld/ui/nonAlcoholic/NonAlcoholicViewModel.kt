package com.example.cocktailworld.ui.nonAlcoholic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailworld.data.model.drinks.AllDrinks
import com.example.cocktailworld.data.model.drinks.Drink
import com.example.cocktailworld.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NonAlcoholicViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    val nonAlcoholic = MutableLiveData<AllDrinks>()
    fun getNonAlcoholic() {

        viewModelScope.launch {
            val result = repository.getNonAlcoholic()
            nonAlcoholic.postValue(result)
        }

    }
}