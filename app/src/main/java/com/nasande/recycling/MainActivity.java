package com.nasande.recycling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.nasande.recycling.model.Product;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiService mApiInstance;
    SharedPrefManager sharedPrefManager;
    ProgressDialog mProgressDialog;
    private RecyclerView recyclerView;
    private itemAdapter ia;
    private List<Product> productList;
    private TextView texte;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);



        productList = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);

        productList = loadJson(this);


        recyclerView.setLayoutManager(layoutManager);

        ia = new itemAdapter(productList,this);


        recyclerView.setAdapter(ia);
        ia.notifyDataSetChanged();







    }

    public List<Product> loadJson(final Context context){

        mApiInstance = new RetrofitInstance().ObtenirInstance();

        Call<List<Product>> call = mApiInstance.getProduct();
        List<Product> p;



        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {



                productList = response.body();


            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

        return productList;
    }
}
