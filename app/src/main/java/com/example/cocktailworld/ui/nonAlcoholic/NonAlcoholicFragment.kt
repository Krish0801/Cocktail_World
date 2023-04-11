package com.example.cocktailworld.ui.nonAlcoholic

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
import com.example.cocktailworld.databinding.FragmentNonAlcoholicBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NonAlcoholicFragment : Fragment() {

    private var _binding: FragmentNonAlcoholicBinding? = null
    private lateinit var viewModel: NonAlcoholicViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this)[NonAlcoholicViewModel::class.java]
        _binding = FragmentNonAlcoholicBinding.inflate(inflater, container, false)

        viewModel.nonAlcoholic.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        viewModel.getNonAlcoholic()

        return binding.root
    }

    private fun setupUI(nonAlcoholic: AllDrinks) {
        val nonAlcoholicAdapter = NonAlcoholicAdapter(nonAlcoholic.drinks as List<Drink>?)
        binding.rvNonAlcoholic.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = nonAlcoholicAdapter
        }
        nonAlcoholicAdapter.onItemClick = {
            val bundle = Bundle().apply {
                putSerializable("NonAlcoholicItem", it)
            }
            findNavController().navigate(
                R.id.action_navigation_non_alcoholic_to_nonAlcoholicDetailFragment, bundle
            )
        }

    }
}