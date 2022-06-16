package com.stockbit.hiring.feature.cryptowatcher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.stockbit.hiring.R
import org.koin.android.viewmodel.ext.android.viewModel


class CryptoWatcherView: AppCompatActivity() {
//    private var binding: WatchlistFragmentBinding by autoCleared()
    private val viewModel: CryptoWatchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cryptowatcher)
//        configureNavController()
    }



}