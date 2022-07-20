package com.example.peopleinfapp.data.remote.models

import com.example.peopleinfapp.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class PeopleModel(

    @SerializedName("id")
    override var id: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("age")
    val age: String,

    @SerializedName("eye_color")
    val eye_color: String,

    @SerializedName("hair_color")
    val hair_color: String,

) : IBaseDiffModel