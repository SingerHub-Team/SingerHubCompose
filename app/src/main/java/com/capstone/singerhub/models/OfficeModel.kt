package com.capstone.singerhub.models


data class OfficeModel(
    val id: Int,
    val name: String,
    val place: String,
    val officeIcon: String,
    val lat: Float,
    val lon: Float,
)