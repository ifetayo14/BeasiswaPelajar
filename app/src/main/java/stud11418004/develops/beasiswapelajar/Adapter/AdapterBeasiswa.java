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
import stud11418004.develops.beasiswapelajar.R;

public class AdapterBeasiswa extends RecyclerView.Adapter<AdapterBeasiswa.ViewHolder> {


    private Context mCtx;
    private List<Beasiswa> beasiswaList;

    public AdapterBeasiswa(Context mCtx, List<Beasiswa> beasiswaList) {
        this.mCtx = mCtx;
        this.beasiswaList = beasiswaList;
    }

    @NonNull
    @Override
    public AdapterBeasiswa.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.beasiswa_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBeasiswa.ViewHolder holder, int position) {
        Beasiswa beasiswa = beasiswaList.get(position);

        holder.textViewName.setText(beasiswa.getNama());
        holder.textViewDeskripsi.setText(beasiswa.getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return beasiswaList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.beasiswa_title);
            textViewDeskripsi = itemView.findViewById(R.id.beasiswa_desc);
        }
    }

//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beasiswa_cardview, parent, false);
//        return new ListViewHolder(view);
//    }

//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        ((ListViewHolder) holder).bindView(position);
//    }
//
//    @Override
//    public int getItemCount() {
//        return BeasiswaData.title.length;
//    }
//
//    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//        private TextView title;
//        private TextView desc;
//
//        public ListViewHolder(View view){
//            super(view);
//            title = view.findViewById(R.id.beasiswa_title);
//            desc = view.findViewById(R.id.beasiswa_desc);
//            view.setOnClickListener(this);
//        }
//
//        public void bindView(int position){
//            title.setText(BeasiswaData.title[position]);
//            desc.setText(BeasiswaData.desc[position]);
//        }
//
//        public void onClick(View view){
//
//        }
//    }
}
