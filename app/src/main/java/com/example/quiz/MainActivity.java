package com.example.quiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView questionText;
    private RadioGroup radioGroup;
    private RadioButton radioBtn1, radioBtn2, radioBtn3;
    private Button btnNext;

    private List<Pytanie> listaPytan;
    private int aktualnePytanieIndex = 0;
    private int punkty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        questionText = findViewById(R.id.questionText);
        radioGroup = findViewById(R.id.radioGroup);
        radioBtn1 = findViewById(R.id.radioBtn1);
        radioBtn2 = findViewById(R.id.radioBtn2);
        radioBtn3 = findViewById(R.id.radioBtn3);
        btnNext = findViewById(R.id.btnNext);

        wypelnijPytania();
        zaladujPytanie();

        btnNext.setOnClickListener(v -> {
            sprawdzOdpowiedz();
            aktualnePytanieIndex++;

            if (aktualnePytanieIndex >= listaPytan.size()) {
                aktualnePytanieIndex = 0;
                Toast.makeText(this, "Koniec quizu! Punkty: " + punkty, Toast.LENGTH_SHORT).show();
            }

            zaladujPytanie();
        });
    }

    private void wypelnijPytania() {
        listaPytan = new ArrayList<>();
        listaPytan.add(new Pytanie(R.drawable.zad1, "Które to schronisko?", "Na Rysiance.", "Na Wielkiej Raczy.", "Na Wielkiej Rycerzowej.", 1));
        listaPytan.add(new Pytanie(R.drawable.zad2, "Zwierzę na zdjęciu to", "owczarek.", "wilk.", "kozica.", 0));
        listaPytan.add(new Pytanie(R.drawable.zad3, "W oddali są widoczne", "Himalaje.", "Alpy.", "Tatry.", 2));
    }

    private void zaladujPytanie() {
        Pytanie p = listaPytan.get(aktualnePytanieIndex);
        imageView.setImageResource(p.idObrazka);
        questionText.setText(p.trescPytania);
        radioBtn1.setText(p.odp1);
        radioBtn2.setText(p.odp2);
        radioBtn3.setText(p.odp3);
        radioGroup.clearCheck();
    }

    private void sprawdzOdpowiedz() {
        int wybranyId = radioGroup.getCheckedRadioButtonId();
        if (wybranyId == -1) return;

        View radioButton = radioGroup.findViewById(wybranyId);
        int indexOdpowiedzi = radioGroup.indexOfChild(radioButton);

        Pytanie aktualne = listaPytan.get(aktualnePytanieIndex);
        if (indexOdpowiedzi == aktualne.poprawnaOdpIndex) {
            punkty++;
        }
    }
}