package com.example.peopleinfapp.ui.fragments.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.peopleinfapp.Either
import com.example.peopleinfapp.R
import com.example.peopleinfapp.base.BaseFragment
import com.example.peopleinfapp.databinding.FragmentPeopleDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PeopleDetailFragment : BaseFragment<PeopleDetailViewModel, FragmentPeopleDetailBinding>(
    R.layout.fragment_people_detail
) {

    override val viewModel: PeopleDetailViewModel by viewModels()
    override val binding by viewBinding(FragmentPeopleDetailBinding::bind)
    private val args: PeopleDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        subscribeToIdHeroes()
    }

    private fun subscribeToIdHeroes() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchIdPeoples(args.id).collect {
                when (it) {
                    is Either.Left -> {
                        Log.e("son", it.value)
                    }
                    is Either.Right -> {
                        binding.nameTv.text = it.value.name
                        binding.ageTv.text = it.value.age
                        binding.genderTv.text = it.value.eye_color
                        binding.hairColorTv.text = it.value.hair_color
                    }
                }
            }
        }
    }
}