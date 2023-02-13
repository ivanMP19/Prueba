package com.example.prueba.ui.productsList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.prueba.R
import com.example.prueba.databinding.FragmentProductListBinding
import com.example.prueba.utils.NetworkState
import com.example.prueba.utils.Constantes.SEARCH_PRODUCTS
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class ProductsListFragment : Fragment() {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    private val viewModel : ProductsListViewModel by viewModels()
    private lateinit var mAdapter : MovieRecyclerView
    private var searchProducts : String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(SEARCH_PRODUCTS)?.let { searchProducts = it }

        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView(){
        mAdapter = MovieRecyclerView()
        val mGridLayout = GridLayoutManager(requireContext(),resources.getInteger(R.integer.main_columns))

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter=mAdapter
        }

    }

    private fun setupObservers() {
        viewModel.movies.observe(viewLifecycleOwner) {
            when (it.status) {
                NetworkState.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) mAdapter.setItems(ArrayList(it.data))
                }
                NetworkState.Status.FAILED ->
                    Toast.makeText(requireContext(), it.msg, Toast.LENGTH_LONG).show()

                NetworkState.Status.RUNNING ->
                    binding.progressBar.visibility = View.VISIBLE
                else -> {
                    Toast.makeText(requireContext(), it.msg, Toast.LENGTH_LONG).show()
                }
            }
        }
    }


}