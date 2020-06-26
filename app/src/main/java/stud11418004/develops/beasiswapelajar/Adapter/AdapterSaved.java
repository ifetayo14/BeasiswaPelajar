package stud11418004.develops.beasiswapelajar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import stud11418004.develops.beasiswapelajar.Entity.BeasiswaData;
import stud11418004.develops.beasiswapelajar.Model.Beasiswa;
import stud11418004.develops.beasiswapelajar.Model.Saved;
import stud11418004.develops.beasiswapelajar.R;

public class AdapterSaved extends RecyclerView.Adapter<AdapterSaved.ViewHolder>{

    private Context mCtx;
    private List<Saved> savedList;

    public AdapterSaved(Context mCtx, List<Saved> savedList) {
        this.mCtx = mCtx;
        this.savedList = savedList;
    }

    @NonNull
    @Override
    public AdapterSaved.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.saved_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Saved saved = savedList.get(position);

        holder.textViewName.setText(saved.getNama());
        holder.textViewDeskripsi.setText(saved.getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return savedList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.saved_title);
            textViewDeskripsi = itemView.findViewById(R.id.saved_desc);
        }
    }
}
