package com.example.konkler;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<k> pytania;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/blopixd/retrofit_pytania/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JSONPlaceholderAPI jsonPlaceholderAPI = retrofit.create(JSONPlaceholderAPI.class);
        Call<List<k>> call = jsonPlaceholderAPI.getPytania();
        call.enqueue(
                new Callback<List<k>>() {
                    @Override
                    public void onResponse(Call<List<k>> call, Response<List<k>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(MainActivity.this, ""+response.code(), Toast.LENGTH_SHORT).show();
                        }
                        pytania = response.body();
                        Toast.makeText(MainActivity.this, pytania.get(0).gettP(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<List<k>> call, Throwable t) {
                        //fokin die
                        Toast.makeText(MainActivity.this,  ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}