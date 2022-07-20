package com.example.peopleinfapp.ui.fragments

import com.example.peopleinfapp.base.BaseViewModel
import com.example.peopleinfapp.data.remote.models.PeopleModel
import com.example.peopleinfapp.data.repositories.PeopleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val repository: PeopleRepository
) : BaseViewModel() {

    private val _peoplesState = mutableUIStateFlow<List<PeopleModel>>()
    val peopleState = _peoplesState.asStateFlow()

    init {
        fetchPeoples()
    }

    private fun fetchPeoples() = repository.fetchPeoples().collectRequest(_peoplesState)
}