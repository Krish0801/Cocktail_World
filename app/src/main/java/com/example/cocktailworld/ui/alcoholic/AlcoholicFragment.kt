package com.example.cocktailworld.ui.alcoholic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocktailworld.R
import com.example.cocktailworld.data.model.drinks.AllDrinks
import com.example.cocktailworld.data.model.drinks.Drink
import com.example.cocktailworld.databinding.FragmentAlcoholicBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlcoholicFragment : Fragment() {

    private var _binding: FragmentAlcoholicBinding? = null
    private lateinit var viewModel: AlcoholicViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this)[AlcoholicViewModel::class.java]
        _binding = FragmentAlcoholicBinding.inflate(inflater, container, false)

        viewModel.alcoholic.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        viewModel.getAlcoholic()

        return binding.root
    }

    private fun setupUI(alcoholic: AllDrinks) {
        val alcoholicAdapter = AlcoholicAdapter(alcoholic.drinks as List<Drink>?)
        binding.rvAlcoholic.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = alcoholicAdapter
        }
        alcoholicAdapter.onItemClick = {
            val bundle = Bundle().apply {
                putSerializable("AlcoholicItem", it)
            }
//            findNavController().navigate(
//                R.id.action_navigation_artworks_to_navigation_artworksDetails, bundle
//            )
        }

    }
}