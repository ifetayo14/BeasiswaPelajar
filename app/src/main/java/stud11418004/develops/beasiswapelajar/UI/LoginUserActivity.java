package stud11418004.develops.beasiswapelajar.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import stud11418004.develops.beasiswapelajar.API.APIClient;
import stud11418004.develops.beasiswapelajar.R;
import stud11418004.develops.beasiswapelajar.Response.LoginResponse;
import stud11418004.develops.beasiswapelajar.Session.SharedPrefManager;

public class LoginUserActivity extends AppCompatActivity {
    EditText email, password;
    TextView textView;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        TextView textView = findViewById(R.id.buatakun);
        loginBtn = findViewById(R.id.loginSiswa);

        email = findViewById(R.id.emailSiswa);
        password = findViewById(R.id.passwordSiswa);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginUserActivity.this, DaftarUserActivity.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
//            Intent intent = new Intent(this, MainActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(intent);
//        }
//    }

    private void login(){
        String getEmail = email.getText().toString().trim();
        String getPassword = password.getText().toString().trim();

        if (getEmail.isEmpty()) {
            email.setError("Email tidak boleh kosong.");
            email.requestFocus();
            return;
        }

        if (getPassword.isEmpty()) {
            password.setError("Password tidak boleh kosong.");
            password.requestFocus();
            return;
        }

        Call<LoginResponse> call = APIClient
                .getInstance()
                .getAPI()
                .Login(getEmail, getPassword);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                if (loginResponse.isError()) {

                    Toast.makeText(LoginUserActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                }
                else {
                    SharedPrefManager.getInstance(LoginUserActivity.this)
                            .saveMahasiswa(loginResponse.getMahasiswa());

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}
