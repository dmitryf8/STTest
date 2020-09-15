package com.mcoolapp.sttestapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.mcoolapp.sttestapp.MainActivity
import com.mcoolapp.sttestapp.R
import kotlinx.android.synthetic.main.fragment_start.view.*


class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var fragment: Fragment = CurrencyListFragment()

        loadFragment(fragment)

        view.bottomNavView.setOnNavigationItemSelectedListener {
            return@setOnNavigationItemSelectedListener when (it.itemId) {
                R.id.currency_list -> {
                    fragment = CurrencyListFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.currency_converter -> {
                    fragment = CurrencyConverterFragment()
                    loadFragment(fragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun getSupportFragmentManager(): FragmentManager {
        return (activity as MainActivity).supportFragmentManager
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            return true
        }
        return false
    }

}