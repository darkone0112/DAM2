package com.example.authjorge;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import APIService.LoginResponse;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginResponse> mlData;

    //Constructor objeto MutableLiveData
    public LoginViewModel() {
        mlData = new MutableLiveData<LoginResponse>();
    }

    public LiveData<LoginResponse> getLoginResponse() {
        return mlData;
    }

    public void hacerLogin(String user, String password) {
        //Aqui llega

        mlData.postValue(respuesta);
    }

}
