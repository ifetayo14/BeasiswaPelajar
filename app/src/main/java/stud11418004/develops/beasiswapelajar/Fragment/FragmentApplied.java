package stud11418004.develops.beasiswapelajar.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import stud11418004.develops.beasiswapelajar.API.APIClient;
import stud11418004.develops.beasiswapelajar.Adapter.AdapterApplied;
import stud11418004.develops.beasiswapelajar.Model.Applied;
import stud11418004.develops.beasiswapelajar.R;
import stud11418004.develops.beasiswapelajar.Response.AppliedResponse;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentApplied extends Fragment {

    private RecyclerView recyclerView;
    private AdapterApplied adapter;
    private List<Applied> appliedList;

    public FragmentApplied() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RelativeLayout rootView = (RelativeLayout) inflater.inflate(R.layout.fragment_applied, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_applied);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<AppliedResponse> call = APIClient.getInstance().getAPI().getAllApplied();

        call.enqueue(new Callback<AppliedResponse>() {
            @Override
            public void onResponse(Call<AppliedResponse> call, Response<AppliedResponse> response) {
                appliedList = response.body().getAppliedList();
                adapter = new AdapterApplied(getContext(), appliedList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<AppliedResponse> call, Throwable t) {

            }
        });
    }
}
