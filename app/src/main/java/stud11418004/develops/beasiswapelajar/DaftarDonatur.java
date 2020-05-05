package stud11418004.develops.beasiswapelajar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DaftarDonatur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_donatur);

        TextView textView = findViewById(R.id.masukakun);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarDonatur.this, LoginDonatur.class);
                startActivity(intent);
            }
        });

        TextView tvPelajar = findViewById(R.id.pelajar);

        tvPelajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarDonatur.this, DaftarPelajar.class);
                startActivity(intent);
            }
        });

        TextView tvDonatur = findViewById(R.id.donatur);

        tvDonatur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarDonatur.this, DaftarDonatur.class);
                startActivity(intent);
            }
        });
    }
}
