package com.capstone.singerhub.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    @SerializedName("Alamat_Tempat_Tinggal")
    val address: String,
    @SerializedName("Latitude")
    val lat: Float,
    @SerializedName("Pengalaman_Bernyanyi")
    val experience: Int,
    @SerializedName("ID")
    val id: String,
    @SerializedName("Longitude")
    val lon: Float,
    @SerializedName("Keterampilan_Alat_Musik")
    val skill: String,
    @SerializedName("Daerah_Asal")
    val origin: String,
    @SerializedName("Genre_Musik")
    val genre: String,
    @SerializedName("Jenis_Kelamin")
    val sex: String,
    @SerializedName("Nama_Lengkap")
    val fullName: String,
    @SerializedName("Umur")
    val age: Int
) : Parcelable