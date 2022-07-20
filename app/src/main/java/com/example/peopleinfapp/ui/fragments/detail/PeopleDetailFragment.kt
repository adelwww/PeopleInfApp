package com.example.peopleinfapp.ui.fragments.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.peopleinfapp.R
import com.example.peopleinfapp.base.BaseFragment
import com.example.peopleinfapp.databinding.FragmentPeopleDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleDetailFragment : BaseFragment<PeopleDetailViewModel, FragmentPeopleDetailBinding>(
    R.layout.fragment_people_detail
) {

    override val viewModel: PeopleDetailViewModel by viewModels()
    override val binding by viewBinding(FragmentPeopleDetailBinding::bind)
    private val args: PeopleDetailFragmentArgs by navArgs()

    override fun setupSubscribe() {
        setupToIdHeroes()
    }

    private fun setupToIdHeroes(){
    }
}