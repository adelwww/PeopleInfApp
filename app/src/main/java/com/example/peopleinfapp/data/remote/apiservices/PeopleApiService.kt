package com.example.peopleinfapp.data.remote.apiservices

import com.example.peopleinfapp.data.remote.models.PeopleModel
import retrofit2.http.GET
import retrofit2.http.Path

interface PeopleApiService {

    @GET("/people")
    suspend fun fetchPeoples(): List<PeopleModel>

    @GET("/people/{id}")
    suspend fun fetchIdPeoples(
        @Path("id") id : String
    ): PeopleModel

}