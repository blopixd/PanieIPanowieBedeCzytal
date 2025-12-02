package com.example.konkler;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
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
    private TextView tresc1;
    private TextView tresc2;
    private TextView tresc3;
    private RadioButton odp1;
    private RadioButton odp2;
    private RadioButton odp3;

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
                        tresc1 = findViewById(R.id.textView);
                        tresc1.setText(pytania.get(0).gettP());
                        odp1 = findViewById(R.id.radioButton);
                        odp2 = findViewById(R.id.radioButton2);
                        odp3 = findViewById(R.id.radioButton3);
                        odp1.setText(pytania.get(0).getoA());
                        odp2.setText(pytania.get(0).getoB());
                        odp3.setText(pytania.get(0).getoC());

                        tresc2 = findViewById(R.id.textView6);
                        tresc2.setText(pytania.get(1).gettP());

                        tresc3 = findViewById(R.id.textView7);
                        tresc3.setText(pytania.get(2).gettP());


                        //Toast.makeText(MainActivity.this, pytania.get(0).gettP(), Toast.LENGTH_SHORT).show();
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