package com.example.cocktailworld.ui.nonAlcoholic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cocktailworld.databinding.FragmentNonAlcoholicBinding

class NonAlcoholicFragment : Fragment() {

    private var _binding: FragmentNonAlcoholicBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val nonAlcoholicViewModel =
            ViewModelProvider(this).get(NonAlcoholicViewModel::class.java)

        _binding = FragmentNonAlcoholicBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        nonAlcoholicViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}