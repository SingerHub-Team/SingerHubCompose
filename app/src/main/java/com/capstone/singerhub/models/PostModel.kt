package com.capstone.singerhub.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
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
) : Parcelable