package com.capstone.singerhub.utils

import com.capstone.singerhub.models.GetUserDataResponse
import com.capstone.singerhub.models.LoginModel
import com.capstone.singerhub.models.LoginResponse
import com.capstone.singerhub.models.LogoutResponse
import com.capstone.singerhub.models.RegisterModel
import com.capstone.singerhub.models.RegisterResponse
import com.capstone.singerhub.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
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
    @POST("login")
    suspend fun login(
        @Body
        loginModel: LoginModel
    ): LoginResponse

    @FormUrlEncoded
    @POST("logout")
    suspend fun logout(
        @Field("uid")
        uid: String,
    ): LogoutResponse

    @POST("register-account")
    suspend fun register(
        @Body
        registerModel: RegisterModel
    ): RegisterResponse

    @FormUrlEncoded
    @GET("get-user-data")
    suspend fun getUserData(
        @Query("id")
        id: String
    ): GetUserDataResponse

    @FormUrlEncoded
    @GET("get-user-data")
    suspend fun getUserDataWithUID(
        @Query("uid")
        uid: String
    ): GetUserDataResponse
}
