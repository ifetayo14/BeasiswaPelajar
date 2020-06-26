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
import stud11418004.develops.beasiswapelajar.Adapter.AdapterBeasiswa;
import stud11418004.develops.beasiswapelajar.Adapter.AdapterSaved;
import stud11418004.develops.beasiswapelajar.Model.Saved;
import stud11418004.develops.beasiswapelajar.R;
import stud11418004.develops.beasiswapelajar.Response.SavedResponse;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSaved extends Fragment {

    private RecyclerView recyclerView;
    private AdapterSaved adapter;
    private List<Saved> savedList;

    public FragmentSaved() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RelativeLayout rootView = (RelativeLayout) inflater.inflate(R.layout.fragment_saved, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_saved);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<SavedResponse> call = APIClient.getInstance().getAPI().getAllSaved();

        call.enqueue(new Callback<SavedResponse>() {
            @Override
            public void onResponse(Call<SavedResponse> call, Response<SavedResponse> response) {
                savedList = response.body().getSavedList();
                adapter = new AdapterSaved(getContext(), savedList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<SavedResponse> call, Throwable t) {

            }
        });
    }
}
