package com.example.cryptoapp.di

import com.example.cryptoapp.common.Constants
import com.example.cryptoapp.data.remote.api.CoinApi
import com.example.cryptoapp.data.repository.CoinRepositoryImpl
import com.example.cryptoapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesApi(): CoinApi {

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCoinRepo(api: CoinApi):CoinRepository{
        return CoinRepositoryImpl(api)
    }

}