package stud11418004.develops.beasiswapelajar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginAdmin extends AppCompatActivity {

    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        TextView tvPelajar = findViewById(R.id.pelajar);

        tvPelajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginAdmin.this, LoginPelajar.class);
                startActivity(intent);
            }
        });

        TextView tvDonatur = findViewById(R.id.donatur);

        tvDonatur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginAdmin.this, LoginDonatur.class);
                startActivity(intent);
            }
        });

        TextView tvAdmin = findViewById(R.id.admin);

        tvAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginAdmin.this, LoginAdmin.class);
                startActivity(intent);
            }
        });

        loginBtn = findViewById(R.id.loginSiswa);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginAdmin.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }
}
