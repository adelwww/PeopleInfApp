package com.example.peopleinfapp.ui.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.peopleinfapp.R
import com.example.peopleinfapp.base.BaseFragment
import com.example.peopleinfapp.databinding.FragmentPeopleBinding
import com.example.peopleinfapp.ui.adapters.PeopleAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : BaseFragment<PeopleViewModel, FragmentPeopleBinding>(
    R.layout.fragment_people
) {

    override val viewModel: PeopleViewModel by viewModels()
    override val binding by viewBinding(FragmentPeopleBinding::bind)
    private val peopleAdapter = PeopleAdapter(this::onItemClick)

    override fun initialize() {
        setupAdapter()
    }

    private fun setupAdapter() = with(binding.recycler) {
        val linerLayoutManager = LinearLayoutManager(context)
        layoutManager = linerLayoutManager
        adapter = peopleAdapter
    }

    override fun setupSubscribe() {
        viewModel.peopleState.collectUIState(
            error = {
                Log.e("son", it)
            },
            success = {
                peopleAdapter.submitList(it)
            }
        )
    }

    private fun onItemClick(id:String){
        findNavController().navigate(
            PeopleFragmentDirections.actionPeopleFragmentToPeopleDetailFragment(id)
        )
    }
}
