package com.example.prueba.ui.searchProduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.prueba.R
import com.example.prueba.databinding.FragmentSearchProductBinding
import com.example.prueba.utils.Constantes

class SearchProductFragment : Fragment() {

    private var _binding: FragmentSearchProductBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initElements()
    }

    private fun initElements(){
        binding.btnSearch.setOnClickListener { goToProductList() }
    }

    private fun goToProductList(){
        if (binding.edtSearch.text.toString().isNotEmpty()){
            findNavController().navigate(
                R.id.action_nav_home_searchListFragment_productListFragment,
                bundleOf(Constantes.SEARCH_PRODUCTS to binding.edtSearch.text.toString())
            )
        }else{
            Toast.makeText(requireContext(),"Ingrese una busqueda", Toast.LENGTH_LONG).show()
        }
    }

}