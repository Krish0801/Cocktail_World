package com.example.cocktailworld.ui.nonAlcoholicDetail

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
import com.example.cocktailworld.databinding.FragmentNonAlcoholicDetailBinding
import com.example.cocktailworld.ui.alcoholicDetail.AlcoholicDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NonAlcoholicDetailFragment : Fragment() {

    private var _binding: FragmentNonAlcoholicDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: NonAlcoholicDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[NonAlcoholicDetailViewModel::class.java]
        _binding = FragmentNonAlcoholicDetailBinding.inflate(inflater, container, false)

        val nonAlcoholic = arguments?.getSerializable("AlcoholicItem") as Drink

        binding.id.text = nonAlcoholic.idDrink
        binding.name.text = nonAlcoholic.strDrink
        binding.category.text = nonAlcoholic.strCategory
        binding.type.text = nonAlcoholic.strAlcoholic
        binding.glassType.text = nonAlcoholic.strGlass
        binding.instructions.text = nonAlcoholic.strInstructions

        Glide.with(this)
            .load(nonAlcoholic?.strDrinkThumb) // image url
            .placeholder(R.color.cocktail_pink) // any placeholder to load at start
            .error(R.mipmap.ic_launcher_cocktail)  // any image in case of error
            .override(200, 200) // resizing
            .centerCrop()
            .into(binding.avatar);


        return binding.root
    }

}