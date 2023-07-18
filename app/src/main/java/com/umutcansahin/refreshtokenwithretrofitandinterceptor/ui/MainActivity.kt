package com.umutcansahin.refreshtokenwithretrofitandinterceptor.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.umutcansahin.refreshtokenwithretrofitandinterceptor.R
import com.umutcansahin.refreshtokenwithretrofitandinterceptor.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getCharacter()
        viewModel.character.observe(this){response->
            binding.apply {
                textViewId.text = response.id.toString()
                textViewName.text = response.name
            }
        }
    }
}