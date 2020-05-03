package stud11418004.develops.beasiswapelajar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterSaved extends RecyclerView.Adapter<AdapterSaved.ViewHolder> {

    private ArrayList<String> rvTitle;
    private ArrayList<String> rvDesc;

    public AdapterSaved(ArrayList<String> inputTitle, ArrayList<String> inputDesc) {
        rvTitle = inputTitle;
        rvDesc = inputDesc;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public TextView tvSubtitle;

        public ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tv_title_beasiswa);
            tvSubtitle = (TextView) v.findViewById(R.id.tv_subtitle_beasiswa);
        }
    }

    @NonNull
    @Override
    public AdapterSaved.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_beasiswa, parent, false);
        AdapterSaved.ViewHolder vh = new AdapterSaved.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSaved.ViewHolder holder, int position) {
        final String title = rvTitle.get(position);
        final String desc = rvDesc.get(position);
        holder.tvTitle.setText(rvTitle.get(position));
        holder.tvSubtitle.setText(rvDesc.get(position));
    }

    @Override
    public int getItemCount() {
        return rvTitle.size();
    }
}
