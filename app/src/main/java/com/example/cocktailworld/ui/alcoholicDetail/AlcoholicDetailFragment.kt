package com.example.cocktailworld.ui.alcoholicDetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cocktailworld.R
import com.example.cocktailworld.data.model.id.Drink
import com.example.cocktailworld.databinding.FragmentAlcoholicDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlcoholicDetailFragment : Fragment() {

    private var _binding: FragmentAlcoholicDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AlcoholicDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[AlcoholicDetailViewModel::class.java]
        _binding = FragmentAlcoholicDetailBinding.inflate(inflater, container, false)

        val alcoholic = arguments?.getSerializable("AlcoholicItem") as Drink

        binding.id.text = alcoholic.idDrink
        binding.name.text = alcoholic.strDrink
        binding.category.text = alcoholic.strCategory
        binding.type.text = alcoholic.strAlcoholic
        binding.glassType.text = alcoholic.strGlass
        binding.instructions.text = alcoholic.strInstructions

        Glide.with(this)
            .load(alcoholic?.strDrinkThumb) // image url
            .placeholder(R.color.cocktail_pink) // any placeholder to load at start
            .error(R.mipmap.ic_launcher_cocktail)  // any image in case of error
            .override(200, 200) // resizing
            .centerCrop()
            .into(binding.avatar);


        return binding.root
    }

}