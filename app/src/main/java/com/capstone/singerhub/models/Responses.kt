package com.capstone.singerhub.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("uid")
    val uid: String,
    @SerializedName("id_token")
    val id_token: String
) : Parcelable

@Parcelize
data class RegisterResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("uid")
    val uid: String,
) : Parcelable

@Parcelize
data class LogoutResponse(
    @SerializedName("message")
    val message: String,
) : Parcelable

@Parcelize
data class GetUserDataResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("user_data")
    val user: UserModel
) : Parcelable
