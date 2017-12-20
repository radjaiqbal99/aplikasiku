package com.example.radjaiqbalsh.aplikasiku.Activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.radjaiqbalsh.aplikasiku.Interface.BiodataPresenterInterface;
import com.example.radjaiqbalsh.aplikasiku.Interface.BiodataViewInterface;
import com.example.radjaiqbalsh.aplikasiku.Model.BaseActivity;
import com.example.radjaiqbalsh.aplikasiku.Model.ResponsModel;
import com.example.radjaiqbalsh.aplikasiku.Presenter.BiodataPresenter;
import com.example.radjaiqbalsh.aplikasiku.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class aplikasiku extends BaseActivity implements BiodataViewInterface {
    @BindView(R.id.input_namalengkap)
    EditText namalengkap;
    @BindView(R.id.input_namap)
    EditText namap;
    @BindView(R.id.input_tempatlahir)
    EditText tmptlahir;
    @BindView(R.id.input_tanggallahir)
    EditText tanggallahir;
    @BindView(R.id.input_Alamat)
    EditText Alamat;
    @BindView(R.id.checkjk)
    RadioGroup checkjk;
    @BindView(R.id.input_nohp)
    EditText nohp;
    @BindView(R.id.input_email)
    EditText email;
    @BindView(R.id.inputjk)
    TextView inputjk;
    ProgressDialog pg;
    public BiodataPresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplikasiku);

        pg = new ProgressDialog(this);
        ButterKnife.bind(aplikasiku.this);

        presenter = new BiodataPresenter(this, getApi());
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.check_L:
                if (checked)
                    inputjk.setText("laki - Laki");
                break;
            case R.id.chckf21_2:
                if (checked)
                    inputjk.setText("Perempuan");
        }

    }

    @OnClick(R.id.btnsave) void dobiodata() {
        pg.setMessage("Sending data.....");
        pg.setCancelable(false);
        pg.show();

        String snamalengkap = namalengkap.getText().toString();
        String snamap = namap.getText().toString();
        String stmptlahir = tmptlahir.getText().toString();
        String stgllahir = tanggallahir.getText().toString();
        String sinputjk = inputjk.getText().toString();
        String salamat = Alamat.getText().toString();
        String snohp = nohp.getText().toString();
        String semail = email.getText().toString();

        presenter.dobiodata(snamalengkap, snamap, stmptlahir, stgllahir, sinputjk, salamat, snohp, semail);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onFinishinsert(ResponsModel res) {
        pg.hide();
        Toast.makeText(aplikasiku.this, "Insert succes", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailureinsert() {
        pg.hide();
        Toast.makeText(aplikasiku.this, "Insert failed", Toast.LENGTH_SHORT).show();
    }


}
