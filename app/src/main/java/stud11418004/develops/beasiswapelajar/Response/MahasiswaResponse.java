package stud11418004.develops.beasiswapelajar.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import stud11418004.develops.beasiswapelajar.Model.Mahasiswa;

public class MahasiswaResponse {
    private boolean error;
    @SerializedName("mahasiswa")
    private List<Mahasiswa> mahasiswa;

    public MahasiswaResponse(boolean error, List<Mahasiswa> mahasiswa) {
        this.error = error;
        this.mahasiswa = mahasiswa;
    }

    public boolean isError() {
        return error;
    }

    public List<Mahasiswa> getMahasiswa() {
        return mahasiswa;
    }
}
