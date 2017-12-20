package com.example.radjaiqbalsh.aplikasiku.Interface;

import com.example.radjaiqbalsh.aplikasiku.Model.ResponsModel;

/**
 * Created by Radja iqbal sh on 20/12/2017.
 */

public interface BiodataViewInterface {
    void showLoading();
    void hideLoading();
    void onFinishinsert(ResponsModel res);
    void onFailureinsert();

    void log(String t);


   // void dobiodata(String snamalengkap, String snamap, String stmptlahir, String stgllahir, String sinputjk, String salamat, String snohp, String semail);
}
