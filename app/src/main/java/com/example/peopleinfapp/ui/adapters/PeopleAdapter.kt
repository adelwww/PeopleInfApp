package com.example.peopleinfapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.peopleinfapp.base.BaseDiffUtilItemCallback
import com.example.peopleinfapp.data.remote.models.PeopleModel
import com.example.peopleinfapp.databinding.ItemPeopleBinding

class PeopleAdapter(private val onItemClick: (id: String) -> Unit)
    : ListAdapter<PeopleModel, PeopleAdapter.PeopleViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        return PeopleViewHolder(
            ItemPeopleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class PeopleViewHolder(
        private val binding: ItemPeopleBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun onBind(model: PeopleModel) = with(binding) {
            nameTv.text = model.name
            genderTv.text = model.gender
            ageTv.text = model.age
            eyeColorTv.text = model.eye_color
            hairColorTv.text = model.hair_color

            cvPeople.setOnClickListener {
                onItemClick(model.id)
            }
        }
    }
}