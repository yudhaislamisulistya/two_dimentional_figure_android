package com.example.tugasproject3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Bangun Datar");
    }

    public void setTitle(String title){
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textView = new TextView(this);
        textView.setText(title);
        textView.setTextSize(20);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(getResources().getColor(R.color.colorWhite));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_name) {
            startActivity(new Intent(MainActivity.this, About.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void goBelahKetupat(View view) {
        Intent i = new Intent(MainActivity.this, Hitung.class);
        i.putExtra("Bangun Datar", "Belah Ketupat");
        startActivity(i);
    }

    public void goLayangLayang(View view) {
        Intent i = new Intent(MainActivity.this, Hitung.class);
        i.putExtra("Bangun Datar", "Layang - Layang");
        startActivity(i);
    }

    public void goTrapesium(View view) {
        Intent i = new Intent(MainActivity.this, Hitung.class);
        i.putExtra("Bangun Datar", "Trapesium");
        startActivity(i);
    }

    public void goSegitiga(View view) {
        Intent i = new Intent(MainActivity.this, Hitung.class);
        i.putExtra("Bangun Datar", "Segitiga");
        startActivity(i);
    }
}
