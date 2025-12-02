package com.example.aplikacjajakas;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Pytanie> pytania;

    private TextView trescpytania;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trescpytania = findViewById(R.id.tresc_pytania);
        int pytanie = 0;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/sojusz/retrofit/").addConverterFactory(GsonConverterFactory.create()).build();
        JsonPlaceholderApi jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);
        Call<List<Pytanie>> call = jsonPlaceholderApi.getPytania();


            call.enqueue(
                    new Callback<List<Pytanie>>() {
                        @Override
                        public void onResponse(Call<List<Pytanie>> call, Response<List<Pytanie>> response) {
                            if (!response.isSuccessful()) {
                                Toast.makeText(MainActivity.this,"" + response.code(), Toast.LENGTH_SHORT).show();
                                return;
                            }

                                pytania = response.body();
                                trescpytania.setText((CharSequence) pytania.get(pytanie));

                        }

                        @Override
                        public void onFailure(Call<List<Pytanie>> call, Throwable t) {
                            Toast.makeText(MainActivity.this,"" + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
            );

    }
}