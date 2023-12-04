package com.mariah.ann.thomas.walmartcccountriesoftheworld.ui

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mariah.ann.thomas.walmartcccountriesoftheworld.databinding.CountriesListFragmentBinding

class CountriesFragment : Fragment() {
    private var _binding : CountriesListFragmentBinding? = null

    private val binding get() = _binding!!
    private lateinit var countryAdapter: CountryAdapter
    private var recyclerViewState: Parcelable? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CountriesListFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val countryViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        )[CountryViewModel::class.java]
        countryViewModel.countryData.observe(viewLifecycleOwner) { state ->
            when(state) {
                is UIState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is UIState.Success -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    binding.countriesList.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = CountryAdapter(state.data)
                    }
                }
                is UIState.Error -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    val errorMessage = state.message
                    Toast.makeText(
                        requireContext(),
                        "Error: $errorMessage",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        countryAdapter = CountryAdapter(arrayListOf())

        savedInstanceState?.let {
            recyclerViewState = it.getParcelable("recycler_state")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        recyclerViewState = binding.countriesList.layoutManager?.onSaveInstanceState()
        outState.putParcelable("recycler_state", recyclerViewState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}