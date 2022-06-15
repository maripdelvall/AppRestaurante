package com.example.apprestaurante.ui.restaurante

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.apprestaurante.databinding.FragmentRestauranteBinding
import com.example.apprestaurante.viewModel.RestauranteViewModel

class RestauranteFragment : Fragment() {

    private var _binding: FragmentRestauranteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val restauranteViewModel =
            ViewModelProvider(this).get(RestauranteViewModel::class.java)

        _binding = FragmentRestauranteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textRestaurante
        restauranteViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}