package com.mcoolapp.sttestapp.fragments

import Datum
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mcoolapp.sttestapp.MainActivity
import com.mcoolapp.sttestapp.R
import com.mcoolapp.sttestapp.ViewModelFactory
import com.mcoolapp.sttestapp.adapters.CurrencyListRecyclerViewAdapter
import com.mcoolapp.sttestapp.databinding.FragmentCurrencyListBinding
import com.mcoolapp.sttestapp.repository.ApiHelper
import com.mcoolapp.sttestapp.repository.RetrofitBuilder
import com.mcoolapp.sttestapp.utils.Status
import com.mcoolapp.sttestapp.viewmodels.CurrencyListViewModel

class CurrencyListFragment : Fragment(), LifecycleOwner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var currencyListViewModel: CurrencyListViewModel
    private lateinit var binding: FragmentCurrencyListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        currencyListViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder().apiService))
        ).get(CurrencyListViewModel::class.java)

        currencyListViewModel.getProgressBarVisibility().observeForever {
            (activity as MainActivity).setMainProgressBarVisibility(it)
        }

        // Inflate the layout for this fragment
        binding = FragmentCurrencyListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).setTitleText(getString(R.string.currency_list))

        binding.currencyListRecyclerView.setHasFixedSize(true)
        binding.currencyListRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val list = listOf<Datum>()
        binding.currencyListRecyclerView.isNestedScrollingEnabled = false
        binding.currencyListRecyclerView.adapter = CurrencyListRecyclerViewAdapter(
            list,
            findNavController(),
            currencyListViewModel.repository
        )

        currencyListViewModel.setProgressBarVisible()

        currencyListViewModel.getList().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    currencyListViewModel.setProgressBarInvisible()
                    it.data?.let {
                        (binding.currencyListRecyclerView.adapter as CurrencyListRecyclerViewAdapter)
                            .updateList(it)
                    }
                }

                Status.ERROR -> {
                    currencyListViewModel.setProgressBarInvisible()
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }

                Status.LOADING -> {
                    currencyListViewModel.setProgressBarVisible()
                }
            }
        })
    }
}