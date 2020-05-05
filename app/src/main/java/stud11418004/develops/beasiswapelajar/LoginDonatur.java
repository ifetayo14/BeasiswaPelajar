package stud11418004.develops.beasiswapelajar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginDonatur extends AppCompatActivity {

    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_donatur);

        TextView textView = findViewById(R.id.buatakun);
        loginBtn = findViewById(R.id.loginSiswa);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginDonatur.this, DaftarDonatur.class);
                startActivity(intent);
            }
        });

        TextView tvPelajar = findViewById(R.id.pelajar);

        tvPelajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginDonatur.this, LoginPelajar.class);
                startActivity(intent);
            }
        });

        TextView tvDonatur = findViewById(R.id.donatur);

        tvDonatur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginDonatur.this, LoginDonatur.class);
                startActivity(intent);
            }
        });

        TextView tvAdmin = findViewById(R.id.admin);

        tvAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginDonatur.this, LoginAdmin.class);
                startActivity(intent);
            }
        });



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginDonatur.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }
}
