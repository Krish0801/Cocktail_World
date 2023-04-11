package com.example.cocktailworld.ui.nonAlcoholicDetail

import androidx.lifecycle.ViewModel
import com.example.cocktailworld.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NonAlcoholicDetailViewModel @Inject constructor(
    repository: Repository
): ViewModel() {

}