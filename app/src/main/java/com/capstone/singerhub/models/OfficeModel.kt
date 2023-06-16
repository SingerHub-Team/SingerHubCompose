package com.capstone.singerhub.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OfficeModel(
    val id: Int,
    val name: String,
    val place: String,
    val officeIcon: String,
    val lat: Float,
    val lon: Float,
) : Parcelable