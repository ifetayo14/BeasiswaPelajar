package stud11418004.develops.beasiswapelajar.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import stud11418004.develops.beasiswapelajar.Model.Saved;

public class SavedResponse {
    private boolean error;
    @SerializedName("saved")
    private List<Saved> savedList;

    public SavedResponse(boolean error, List<Saved> savedList) {
        this.error = error;
        this.savedList = savedList;
    }

    public boolean isError() {
        return error;
    }

    public List<Saved> getSavedList() {
        return savedList;
    }
}
