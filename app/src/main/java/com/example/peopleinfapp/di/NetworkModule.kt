package com.example.peopleinfapp.di

import com.example.peopleinfapp.data.remote.retrofit.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providePeoplesApiService(
        networkClient: NetworkClient
    ) = networkClient.providePeoplesApiService()

}