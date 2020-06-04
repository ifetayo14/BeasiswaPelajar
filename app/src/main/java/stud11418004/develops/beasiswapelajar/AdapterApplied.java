package stud11418004.develops.beasiswapelajar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterApplied extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.applied_cardview, parent, false);
        return new AdapterApplied.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((AdapterApplied.ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return BeasiswaData.title.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView title;
        private TextView desc;

        public ListViewHolder(View view){
            super(view);
            title = view.findViewById(R.id.applied_title);
            desc = view.findViewById(R.id.applied_desc);
            view.setOnClickListener(this);
        }

        public void bindView(int position){
            title.setText(BeasiswaData.title[position]);
            desc.setText(BeasiswaData.desc[position]);
        }

        public void onClick(View view){

        }
    }
}
