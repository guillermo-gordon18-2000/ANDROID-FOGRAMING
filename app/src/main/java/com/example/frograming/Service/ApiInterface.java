package com.example.frograming.Service;

import com.example.frograming.Modelos.LoginRequest;
import com.example.frograming.Modelos.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("Login")
    Call<LoginResponse> Loguear (@Body LoginRequest request);
}
