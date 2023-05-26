package com.capstone.singerhub.models

data class PostModel(
    val id: Int,
    val position: String,
    val desc: String,
    val officeId: Int,
    val salaryStart: Int,
    val salaryEnd: Int,
    val salaryPer: String,
    val posted: String,
    val backgroundImage: String?,
)