package com.capstone.singerhub.models

data class UserModel(
    val id: Int,
    val name: String,
    val role: String,
    val email: String,
    val image: String,
    val work_experience: String,
//    val skills: String,
)