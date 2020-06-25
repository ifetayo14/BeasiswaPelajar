package stud11418004.develops.beasiswapelajar.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import stud11418004.develops.beasiswapelajar.R;
import stud11418004.develops.beasiswapelajar.Session.SharedPrefManager;
import stud11418004.develops.beasiswapelajar.UI.LoginUserActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfile extends Fragment {

    private TextView textViewEmail, textViewName, textViewUniv, textViewJurusan, textViewGender, textViewTempat, textViewTanggal, textViewAlamat;
    Button logoutBtn;

    public FragmentProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewEmail = view.findViewById(R.id.textViewEmail);
        textViewName = view.findViewById(R.id.textViewNama);
        textViewUniv = view.findViewById(R.id.textViewUniv);
        textViewJurusan = view.findViewById(R.id.textViewJurusan);
        textViewGender = view.findViewById(R.id.textViewGender);
        textViewTempat = view.findViewById(R.id.textViewPlace);
        textViewTanggal = view.findViewById(R.id.textViewTanggal);
        textViewAlamat = view.findViewById(R.id.textViewAlamat);

        textViewEmail.setText(SharedPrefManager.getInstance(getActivity()).getMahasiswa().getEmail());
        textViewName.setText(SharedPrefManager.getInstance(getActivity()).getMahasiswa().getNama());
        textViewUniv.setText(SharedPrefManager.getInstance(getActivity()).getMahasiswa().getAsal_univ());
        textViewJurusan.setText(SharedPrefManager.getInstance(getActivity()).getMahasiswa().getJurusan());
        textViewGender.setText(SharedPrefManager.getInstance(getActivity()).getMahasiswa().getGender());
        textViewTempat.setText(SharedPrefManager.getInstance(getActivity()).getMahasiswa().getTempat_lahir());
        textViewTanggal.setText(SharedPrefManager.getInstance(getActivity()).getMahasiswa().getTanggal_lahir());
        textViewAlamat.setText(SharedPrefManager.getInstance(getActivity()).getMahasiswa().getAlamat());

        logoutBtn = view.findViewById(R.id.buttonLogout);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefManager.getInstance(getActivity()).clear();
                Intent intent = new Intent(getActivity(), LoginUserActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

}
