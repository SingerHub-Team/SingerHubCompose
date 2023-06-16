package com.capstone.singerhub.ui.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.singerhub.models.RegisterModel
import com.capstone.singerhub.models.RegisterResponse
import com.capstone.singerhub.utils.ApiClient
import com.capstone.singerhub.utils.ApiInterface
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    private val apiInterface by lazy {
        ApiClient.getClient().create(ApiInterface::class.java)
    }

    fun register(
        email: String,
        password: String,
        fullName: String
    ): MutableLiveData<RegisterResponse> {
        val data = MutableLiveData<RegisterResponse>()
        viewModelScope.launch {
            data.value = apiInterface.register(RegisterModel(fullName, email, password))
        }
        return data
    }
}