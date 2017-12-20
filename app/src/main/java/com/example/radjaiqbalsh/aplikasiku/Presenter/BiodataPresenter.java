package com.example.radjaiqbalsh.aplikasiku.Presenter;


import android.util.Log;

import com.example.radjaiqbalsh.aplikasiku.Interface.BiodataPresenterInterface;
import com.example.radjaiqbalsh.aplikasiku.Interface.BiodataViewInterface;
import com.example.radjaiqbalsh.aplikasiku.Model.ApiRequest;
import com.example.radjaiqbalsh.aplikasiku.Model.ResponsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Radja iqbal sh on 20/12/2017.
 */

public class BiodataPresenter implements BiodataPresenterInterface{
    private BiodataViewInterface view;
    private ApiRequest api;

    public BiodataPresenter(BiodataViewInterface view, ApiRequest api) {
        this.view = view;
        this.api = api;
    }

    @Override
    public void dobiodata(String namalengkap, String namapanggilan, String tmptLahir, String tgllahir, String jenisk, String alamat, String nomerhp, String email) {
        view.showLoading();
        view.log("init");

        Call<ResponsModel> send = api.sendBiodata(namalengkap, namapanggilan, tmptLahir, tgllahir, jenisk, alamat, nomerhp, email);
        send.enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(retrofit2.Call<ResponsModel> call, Response<ResponsModel> response) {
                ResponsModel res = response.body();
                if (res.getKode() == 1) {
                    view.onFinishinsert(res);
                } else {
                    view.onFailureinsert();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponsModel> call, Throwable t) {
                view.hideLoading();
                Log.d("Base", "Failur : " + "Gagal mengirim request");
            }

            });
        }



}

