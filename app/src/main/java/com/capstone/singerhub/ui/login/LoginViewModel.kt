package com.capstone.singerhub.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.singerhub.models.LoginModel
import com.capstone.singerhub.models.LoginResponse
import com.capstone.singerhub.utils.ApiClient
import com.capstone.singerhub.utils.ApiInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val apiInterface by lazy {
        ApiClient.getClient().create(ApiInterface::class.java)
    }

    fun login(email: String, password: String): MutableLiveData<LoginResponse> {
        val data = MutableLiveData<LoginResponse>()
        viewModelScope.launch {
            data.value = apiInterface.login(LoginModel(email, password))
        }
        return data
    }
}