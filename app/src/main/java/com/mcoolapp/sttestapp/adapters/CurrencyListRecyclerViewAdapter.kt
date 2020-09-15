package com.mcoolapp.sttestapp.adapters

import Datum
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import com.bumptech.glide.Glide
import com.mcoolapp.sttestapp.databinding.DatumItemLayoutBinding
import com.mcoolapp.sttestapp.repository.Repository

class CurrencyListRecyclerViewAdapter(private var items: List<Datum?>, val navController: NavController, val repository: Repository) :
    androidx.recyclerview.widget.RecyclerView.Adapter<CurrencyListRecyclerViewAdapter.DatumListViewHolder>() {

    class DatumListViewHolder(private val itemBinding: DatumItemLayoutBinding, val navController: NavController, val repository: Repository) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(datum: Datum) {
            itemBinding.currencyNameTextView.text = datum.name
            itemBinding.currencyPriceUSDTextView.text = datum.quote!!.uSD!!.getPrice().toString()

            Glide.with(itemBinding.imageView)
                .load("https://s2.coinmarketcap.com/static/img/coins/64x64/"+datum.id+".png")
                .into(itemBinding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatumListViewHolder {
        val itemBinding =
            DatumItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DatumListViewHolder(itemBinding, navController, repository)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DatumListViewHolder, position: Int) {
        val datum = items[position]
        holder.bind(datum!!)

    }

    fun updateList(list: List<Datum?>) {
        items = list
        notifyDataSetChanged()
    }
}