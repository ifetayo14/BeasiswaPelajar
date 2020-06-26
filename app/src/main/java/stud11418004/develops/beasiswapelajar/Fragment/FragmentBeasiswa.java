package stud11418004.develops.beasiswapelajar.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import stud11418004.develops.beasiswapelajar.API.APIClient;
import stud11418004.develops.beasiswapelajar.Adapter.AdapterBeasiswa;
import stud11418004.develops.beasiswapelajar.Model.Beasiswa;
import stud11418004.develops.beasiswapelajar.R;
import stud11418004.develops.beasiswapelajar.Response.BeasiswaResponse;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBeasiswa extends Fragment {

    private RecyclerView recyclerView;
    private AdapterBeasiswa adapter;
    private List<Beasiswa> beasiswa;

    public FragmentBeasiswa() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RelativeLayout rootView = (RelativeLayout) inflater.inflate(R.layout.fragment_beasiswa, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_beasiswa);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<BeasiswaResponse> call = APIClient.getInstance().getAPI().getAllBeasiswa();

        call.enqueue(new Callback<BeasiswaResponse>() {
            @Override
            public void onResponse(Call<BeasiswaResponse> call, Response<BeasiswaResponse> response) {
                beasiswa = response.body().getBeasiswa();
                adapter = new AdapterBeasiswa(getContext(), beasiswa);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<BeasiswaResponse> call, Throwable t) {

            }
        });
    }
}
