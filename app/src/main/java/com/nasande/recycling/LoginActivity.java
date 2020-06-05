package com.nasande.recycling;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText mUserView;
    private TextInputEditText mPasswordView;
    private Button mConnexion;

    SharedPrefManager sharedPrefManager;
    private ApiService mApiInstance;
    ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPrefManager = new SharedPrefManager(this);
        if (sharedPrefManager.getSPIsLoggedIn()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        mConnexion = findViewById(R.id.login_btn);
        mUserView = findViewById(R.id.username);
        mPasswordView = findViewById(R.id.password);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Connexion ...");



    }

    public void showDialog() {

        if(mProgressDialog != null && !mProgressDialog.isShowing())
            mProgressDialog.show();
    }

    public void hideDialog() {

        if(mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }


}
