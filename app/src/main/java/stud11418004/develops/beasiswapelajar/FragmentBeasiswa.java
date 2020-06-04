package stud11418004.develops.beasiswapelajar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBeasiswa extends Fragment {
    private RecyclerView.Adapter adapter;

    public FragmentBeasiswa() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RelativeLayout rootView = (RelativeLayout) inflater.inflate(R.layout.fragment_beasiswa, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.rv_beasiswa);
        adapter = new AdapterBeasiswa();
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return rootView;
    }
}
