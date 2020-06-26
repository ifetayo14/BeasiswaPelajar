package stud11418004.develops.beasiswapelajar.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import stud11418004.develops.beasiswapelajar.Model.Applied;
import stud11418004.develops.beasiswapelajar.Model.Saved;

public class AppliedResponse {
    private boolean error;
    @SerializedName("applied")
    private List<Applied> appliedList;

    public AppliedResponse(boolean error, List<Applied> appliedList) {
        this.error = error;
        this.appliedList = appliedList;
    }

    public boolean isError() {
        return error;
    }

    public List<Applied> getAppliedList() {
        return appliedList;
    }
}
