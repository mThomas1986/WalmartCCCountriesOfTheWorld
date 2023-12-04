package com.mariah.ann.thomas.walmartcccountriesoftheworld.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mariah.ann.thomas.walmartcccountriesoftheworld.data.model.CountryModel
import com.mariah.ann.thomas.walmartcccountriesoftheworld.databinding.CountriesListItemBinding

class CountryAdapter(
    private var countryList: MutableList<CountryModel>
) : RecyclerView.Adapter<CountryAdapter.ViewHolder>(){

    /*
        create an inner class with name ViewHolder
        that will take a view argument that will pass the generated class of countries_list_item
     */
    inner class ViewHolder(val binding: CountriesListItemBinding) : RecyclerView.ViewHolder(binding.root)

    /*
        inside the onCreateVieHolder inflate the view of CountriesListItemBinding
        and return a new ViewHolder object containing this layout
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CountriesListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    /*
        Bind the recyclerView items (CountriesListItemBinding) with each item
        of the countryList which will be shown in the recyclerView

        Note: We will not set any image data to the view since this is out-of-scope for the code
        challenge.
     */
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (countryList.isNotEmpty()) {
            with(holder) {
                with(countryList[position]) {
                    binding.countryName.text = "${this.name}, ${this.region}"
                    binding.countryCode.text = this.code
                    binding.countryCapital.text = this.capital
                }
            }
        }
    }

    /*
        Returns the size of the countryList
     */
    override fun getItemCount(): Int {
        return countryList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(data: List<CountryModel>) {
        countryList.addAll(data)
        notifyDataSetChanged()
    }
}