package com.example.peopleinfapp.data.repositories

import com.example.peopleinfapp.data.remote.apiservices.PeopleApiService
import com.example.peopleinfapp.data.repositories.base.BaseRepository
import javax.inject.Inject

class PeopleRepository @Inject constructor(
    private val apiService: PeopleApiService
) : BaseRepository() {

    fun fetchPeoples() = doRequest {
        apiService.fetchPeoples()
    }

    fun fetchIdPeoples(id:String) = doRequest {
        apiService.fetchIdPeoples(id)
    }
}