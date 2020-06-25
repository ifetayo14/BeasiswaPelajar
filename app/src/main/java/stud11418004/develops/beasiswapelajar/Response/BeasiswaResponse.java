package stud11418004.develops.beasiswapelajar.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import stud11418004.develops.beasiswapelajar.Model.Beasiswa;

public class BeasiswaResponse {
    private boolean error;
    @SerializedName("beasiswa")
    private List<Beasiswa> beasiswa;

    public BeasiswaResponse(boolean error, List<Beasiswa> beasiswa) {
        this.error = error;
        this.beasiswa = beasiswa;
    }

    public boolean isError() {
        return error;
    }

    public List<Beasiswa> getBeasiswa() {
        return beasiswa;
    }
}
