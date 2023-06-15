package com.capstone.singerhub.utils

import com.capstone.singerhub.models.GetUserDataResponse
import com.capstone.singerhub.models.LoginResponse
import com.capstone.singerhub.models.LogoutResponse
import com.capstone.singerhub.models.RegisterResponse
import com.capstone.singerhub.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object {
        fun getClient(): Retrofit {
            val client = OkHttpClient().newBuilder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build()
            return Retrofit.Builder().baseUrl(BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}

interface ApiInterface {
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email")
        email: String,
        @Field("password")
        password: String,
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("logout")
    fun logout(
        @Field("uid")
        uid: String,
    ): Call<LogoutResponse>

    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("email")
        email: String,
        @Field("password")
        password: String,
        @Field("nama_lengkap")
        name: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @GET("get-user-data")
    fun getUserData(
        @Query("id")
        id: String
    ): Call<GetUserDataResponse>

    @FormUrlEncoded
    @GET("get-user-data")
    fun getUserDataWithUID(
        @Query("uid")
        uid: String
    ): Call<GetUserDataResponse>
}
