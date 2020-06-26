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
import stud11418004.develops.beasiswapelajar.Response.DefaultResponse;

public class DaftarUserActivity extends AppCompatActivity {
    TextView textView;
    private EditText editTextName, editTextUniv, editTextEmail, editTextJurusan, editTextGender, editTextTempatLahir, editTextTanggalLahir, editTextPassword, editTextValidPassword, editTextAlamat;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_user);
        TextView textView = findViewById(R.id.masukakun);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarUserActivity.this, LoginUserActivity.class);
                startActivity(intent);
            }
        });

        editTextName = findViewById(R.id.namaSiswa);
        editTextEmail = findViewById(R.id.emailSiswa);
        editTextUniv = findViewById(R.id.universitas);
        editTextJurusan = findViewById(R.id.jurusan);
        editTextGender = findViewById(R.id.gender);
        editTextTempatLahir = findViewById(R.id.tempatLahir);
        editTextTanggalLahir = findViewById(R.id.tanggalLahir);
        editTextAlamat = findViewById(R.id.alamat);
        editTextPassword = findViewById(R.id.password1Siswa);
        editTextValidPassword = findViewById(R.id.password2Siswa);

        loginBtn = findViewById(R.id.loginSiswa);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextPassword.getText().toString().equals(editTextValidPassword.getText().toString())){
                    Toast.makeText(DaftarUserActivity.this, "Password Anda Tidak Sama", Toast.LENGTH_SHORT).show();
                }
                else{
                    registration();
                }
            }
        });
    }

    private void registration(){
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String univ = editTextUniv.getText().toString().trim();
        String jurusan = editTextJurusan.getText().toString().trim();
        String gender = editTextGender.getText().toString().trim();
        String tempat = editTextTempatLahir.getText().toString().trim();
        String tanggal = editTextTanggalLahir.getText().toString().trim().trim();
        String alamat = editTextAlamat.getText().toString().trim().trim();
        String password = editTextPassword.getText().toString().trim();

        if (name.isEmpty()){
            editTextName.setError("Field Nama Tidak Boleh Kosong");
            editTextName.requestFocus();
            return;
        }

        if (email.isEmpty()){
            editTextEmail.setError("Field Email Tidak Boleh Kosong");
            editTextEmail.requestFocus();
            return;
        }

        if (univ.isEmpty()){
            editTextUniv.setError("Field Universitas Tidak Boleh Kosong");
            editTextUniv.requestFocus();
            return;
        }

        if (jurusan.isEmpty()){
            editTextJurusan.setError("Field Jurusan Tidak Boleh Kosong");
            editTextJurusan.requestFocus();
            return;
        }

        if (gender.isEmpty()){
            editTextGender.setError("Field Gender Tidak Boleh Kosong");
            editTextGender.requestFocus();
            return;
        }

        if (tempat.isEmpty()){
            editTextTempatLahir.setError("Field Tempat Lahir Tidak Boleh Kosong");
            editTextTempatLahir.requestFocus();
            return;
        }

        if (tanggal.isEmpty()){
            editTextTanggalLahir.setError("Field Tanggal Lahir Tidak Boleh Kosong");
            editTextTanggalLahir.requestFocus();
            return;
        }

        if (password.length() < 6){
            editTextPassword.setError("Field Password Harus Lebih Panjang dari 6 Karakter");
            editTextPassword.requestFocus();
            return;
        }

        Call<DefaultResponse> call = APIClient
                .getInstance()
                .getAPI()
                .createMahasiswa(email, name, univ, jurusan, gender, tempat, tanggal, alamat, password);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.code() == 201) {

                    Intent intent = new Intent(DaftarUserActivity.this, LoginUserActivity.class);
                    startActivity(intent);

                    DefaultResponse dr = response.body();
                    Toast.makeText(DaftarUserActivity.this, dr.getMsg(), Toast.LENGTH_LONG).show();

                } else if (response.code() == 422) {
                    Toast.makeText(DaftarUserActivity.this, "Registrasi Berhasil.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(DaftarUserActivity.this, LoginUserActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(DaftarUserActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
