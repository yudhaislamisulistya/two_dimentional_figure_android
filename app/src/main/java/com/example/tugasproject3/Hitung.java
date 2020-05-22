package com.example.tugasproject3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;


public class Hitung extends AppCompatActivity {

    TextView jenisBangunDatar, hasilBangunDatar;
    TextInputLayout nilai1Inputan, nilai2Inputan;
    ImageView gambarJenisBangunDatar;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung);

        jenisBangunDatar =  findViewById(R.id.jenisBangunDatar);
        hasilBangunDatar =  findViewById(R.id.hasilLuas);
        gambarJenisBangunDatar =  findViewById(R.id.gambarJenisBangunDatar);
        nilai1Inputan =  findViewById(R.id.nilai1Inputan);
        nilai2Inputan =  findViewById(R.id.nilai2Inputan);

        i = getIntent();

        prosesUbahAktifitas(i);
    }

    private void prosesUbahAktifitas(Intent i) {
        switch (i.getStringExtra("Bangun Datar")){
            case "Belah Ketupat":
                getSupportActionBar().setTitle("Hitung Luas Belah Ketupat");
                jenisBangunDatar.setText("Belah Ketupat");
                gambarJenisBangunDatar.setImageResource(R.drawable.belahketupat);
                nilai1Inputan.setHint("Diagonal Satu");
                nilai2Inputan.setHint("Diagonal Dua");
                break;
            case "Segitiga":
                getSupportActionBar().setTitle("Hitung Luas Segitiga");
                jenisBangunDatar.setText("Segitiga");
                gambarJenisBangunDatar.setImageResource(R.drawable.segitiga);
                nilai1Inputan.setHint("Alas");
                nilai2Inputan.setHint("Tinggi");
                break;
            case "Trapesium":
                getSupportActionBar().setTitle("Hitung Luas Trapesium");
                jenisBangunDatar.setText("Trapesium");
                gambarJenisBangunDatar.setImageResource(R.drawable.trapesium);
                nilai1Inputan.setHint("Jumlah Sisi Sejajar");
                nilai2Inputan.setHint("Tinggi");
                break;
            case "Layang - Layang":
                getSupportActionBar().setTitle("Hitung Luas Layang Layang");
                jenisBangunDatar.setText("Layang - Layang");
                gambarJenisBangunDatar.setImageResource(R.drawable.layanglayang);
                nilai1Inputan.setHint("Diagonal Satu");
                nilai2Inputan.setHint("Diagonal Dua");
                break;
        }
    }

    public void prosesHitung(View view) {
        double hasil, nilai1, nilai2;

        String s_nilai1 = nilai1Inputan.getEditText().getText().toString();
        String s_nilai2 = nilai2Inputan.getEditText().getText().toString();

        if (!s_nilai1.equals("") || !s_nilai2.equals("")){
            nilai1 = Double.parseDouble(s_nilai1);
            nilai2 = Double.parseDouble(s_nilai2);
            hasil = (0.5 * (nilai1 * nilai2));
            switch (i.getStringExtra("Bangun Datar")){
                case "Belah Ketupat":
                    hasilBangunDatar.setText("Luas Belah Ketupat " + hasil);
                    break;
                case "Segitiga":
                    hasilBangunDatar.setText("Luas Segitiga " + hasil);
                    break;
                case "Trapesium":
                    hasilBangunDatar.setText("Luas Trapesium " + hasil);
                    break;
                case "Layang - Layang":
                    hasilBangunDatar.setText("Luas Layang - Layang " + hasil);
                    break;
            }
        }else{
            Toast.makeText(Hitung.this, "Nilai 1 Atau Nilai 2 Tidak Boleh Kosong Yah!", Toast.LENGTH_SHORT).show();
        }


    }
}
