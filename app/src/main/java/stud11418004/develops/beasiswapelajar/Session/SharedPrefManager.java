package stud11418004.develops.beasiswapelajar.Session;

import android.content.Context;
import android.content.SharedPreferences;

import stud11418004.develops.beasiswapelajar.Model.Mahasiswa;

public class SharedPrefManager {
    private static final String SHARED_PREF_NAME = "my_shared_preff";

    private static SharedPrefManager mInstance;
    private Context mCtx;

    private SharedPrefManager(Context mCtx) {
        this.mCtx = mCtx;
    }


    public static synchronized SharedPrefManager getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(mCtx);
        }
        return mInstance;
    }


    public void saveMahasiswa(Mahasiswa mahasiswa) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("email", mahasiswa.getEmail());
        editor.putString("nama", mahasiswa.getNama());
        editor.putString("asal_univ", mahasiswa.getAsal_univ());
        editor.putString("jurusan", mahasiswa.getJurusan());
        editor.putString("alamat", mahasiswa.getAlamat());
        editor.putString("gender", mahasiswa.getGender());
        editor.putString("tempat_lahir", mahasiswa.getTempat_lahir());
        editor.putString("tanggal_lahir", mahasiswa.getTanggal_lahir());

        editor.apply();
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String parse = sharedPreferences.getString("email" ,"-1");
        return parse.length() > 0;
    }

    public Mahasiswa getMahasiswa() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Mahasiswa(
                sharedPreferences.getString("email", null),
                sharedPreferences.getString("nama", null),
                sharedPreferences.getString("asal_univ", null),
                sharedPreferences.getString("jurusan", null),
                sharedPreferences.getString("alamat", null),
                sharedPreferences.getString("gender", null),
                sharedPreferences.getString("tempat_lahir", null),
                sharedPreferences.getString("tanggal_lahir", null)
        );
    }

    public void clear() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
