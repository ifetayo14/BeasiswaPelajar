package stud11418004.develops.beasiswapelajar.Response;

import com.google.gson.annotations.SerializedName;

import stud11418004.develops.beasiswapelajar.Model.Mahasiswa;

public class LoginResponse {
    private boolean error;
    private String message;
    @SerializedName("mahasiswa")
    private Mahasiswa mahasiswa;

    public LoginResponse(boolean error, String message, Mahasiswa mahasiswa) {
        this.error = error;
        this.message = message;
        this.mahasiswa = mahasiswa;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }
}
