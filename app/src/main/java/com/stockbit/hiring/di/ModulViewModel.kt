package com.stockbit.hiring.di

import com.stockbit.hiring.feature.cryptowatcher.CryptoWatchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        CryptoWatchViewModel(get())
    }
}