package com.example.cocktailworld

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class AlcoholicDetailFragment : Fragment() {

    companion object {
        fun newInstance() = AlcoholicDetailFragment()
    }

    private lateinit var viewModel: AlcoholicDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alcoholic_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AlcoholicDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}