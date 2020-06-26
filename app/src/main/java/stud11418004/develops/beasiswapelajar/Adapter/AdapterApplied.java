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
import stud11418004.develops.beasiswapelajar.Model.Applied;
import stud11418004.develops.beasiswapelajar.Model.Saved;
import stud11418004.develops.beasiswapelajar.R;

public class AdapterApplied extends RecyclerView.Adapter<AdapterApplied.ViewHolder> {

    private Context mCtx;
    private List<Applied> appliedList;

    public AdapterApplied(Context mCtx, List<Applied> appliedList) {
        this.mCtx = mCtx;
        this.appliedList = appliedList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.applied_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Applied applied = appliedList.get(position);

        holder.textViewName.setText(applied.getNama());
        holder.textViewDeskripsi.setText(applied.getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return appliedList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.applied_title);
            textViewDeskripsi = itemView.findViewById(R.id.applied_desc);
        }
    }

}
