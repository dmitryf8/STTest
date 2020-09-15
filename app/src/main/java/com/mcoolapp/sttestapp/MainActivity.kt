package com.mcoolapp.sttestapp

import android.app.usage.NetworkStatsManager
import android.content.Context
import android.net.ConnectivityManager
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.mcoolapp.sttestapp.databinding.ActivityMainBinding
import com.mcoolapp.sttestapp.repository.ApiHelper
import com.mcoolapp.sttestapp.repository.RetrofitBuilder
import com.mcoolapp.sttestapp.utils.Status
import com.mcoolapp.sttestapp.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder().apiService))
        ).get(MainViewModel::class.java)
    }

    fun setMainProgressBarVisibility(visibility: Int) {
        binding.mainProgressBar.visibility = visibility
    }

    fun setTitleText(text: String) {
        binding.headerTitle.text = text
    }
}