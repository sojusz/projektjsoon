package com.example.aplikacjajakas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    TextView questionNumber;
    TextView trescPytania;
    RadioButton odpa;
    RadioButton odpb;
    RadioButton odpc;
    RadioGroup radios;
    int questionindex = 0;
    int currentCorrect = 0;
    Button przycisk;
    int prawidlowe = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://my-json-server.typicode.com/sojusz/retrofit/").addConverterFactory(GsonConverterFactory.create()).build();
        JsonPlaceholderApi jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);
        Call<List<Pytanie>> call = jsonPlaceholderApi.getPytania();
        call.enqueue(new Callback<List<Pytanie>>() {
            @Override
            public void onResponse(Call<List<Pytanie>> call, Response<List<Pytanie>> response) {
                pytania = response.body();
                makeQuestion();
            }

            @Override
            public void onFailure(Call<List<Pytanie>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Nie ma takiej opcji!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void findViews() {
        questionNumber = findViewById(R.id.textView2);
        trescPytania = findViewById(R.id.textView);
        odpa = findViewById(R.id.odpa);
        odpb = findViewById(R.id.odpb);
        odpc = findViewById(R.id.odpc);
        radios = findViewById(R.id.radios);
        przycisk = findViewById(R.id.button);
    }

    private void next() {
        RadioButton rd = (RadioButton) radios.getChildAt(currentCorrect);
        if (rd.isChecked()) {
            prawidlowe ++;
        }
        questionindex++;
        makeQuestion();
    }
    private void makeQuestion() {
        przycisk.setText("Nastepne");
        przycisk.setOnClickListener(v-> {
            next();
        });
        trescPytania.setVisibility(TextView.VISIBLE);
        radios.setVisibility(RadioGroup.VISIBLE);
        if (questionindex >= pytania.size()) {
            trescPytania.setVisibility(TextView.GONE);
            radios.setVisibility(RadioGroup.GONE);
            przycisk.setText("Powtorz quiz");
            przycisk.setOnClickListener(v-> {
                questionindex = 0;
                prawidlowe = 0;
                makeQuestion();
            });
//            przycisk.setVisibility(Button.GONE);
            questionNumber.setText("Punkty: " + prawidlowe + "/" + pytania.size());
            return;
        }
        Pytanie pytanie = pytania.get(questionindex);
        currentCorrect = pytanie.getOpd() - 1;
        questionNumber.setText("Pytanie: " + (questionindex + 1) +  "/" +  pytania.size());
        trescPytania.setText(pytanie.getTrescPytania());
        odpa.setText(pytanie.getOdp1());
        odpb.setText(pytanie.getOdp2());
        odpc.setText(pytanie.getOdp3());
    }
}
