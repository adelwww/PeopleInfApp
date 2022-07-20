package com.example.peopleinfapp.data.remote.retrofit

import com.example.peopleinfapp.data.remote.apiservices.PeopleApiService
import javax.inject.Inject

class NetworkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttp: OkHttp
) {

    private val provideRetrofit = retrofitClient.provideRetrofit(okHttp.provideOkHttpClient())

    fun providePeoplesApiService() = provideRetrofit.create(PeopleApiService::class.java)


}