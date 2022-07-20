package com.example.peopleinfapp.ui.fragments.detail

import com.example.peopleinfapp.base.BaseViewModel
import com.example.peopleinfapp.data.repositories.PeopleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeopleDetailViewModel @Inject constructor(
    private val repository: PeopleRepository
) : BaseViewModel(){

    fun fetchIdPeoples(id: String) =
        repository.fetchIdPeoples(id)
}