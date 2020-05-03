package stud11418004.develops.beasiswapelajar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class SavedBeasiswaActivity extends AppCompatActivity {

    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> dataTitle;
    private ArrayList<String> dataDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beasiswa_saved);

        dataTitle = new ArrayList<>();
        dataDesc = new ArrayList<>();
        initDataset();

        rvView = (RecyclerView) findViewById(R.id.rv_saved);
        rvView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        adapter = new AdapterBeasiswa(dataTitle, dataDesc);
        rvView.setAdapter(adapter);
    }

    private void initDataset(){
        dataTitle.add("Beasiswa Tanoto");
        dataDesc.add("Deskripsi Beasiswa");

        dataTitle.add("Beasiswa Rajawali");
        dataDesc.add("Deskripsi Beasiswa");

        dataTitle.add("Beasiswa Bidik Misi");
        dataDesc.add("Deskripsi Beasiswa");

        dataTitle.add("Beasiswa Ikatan Dinas");
        dataDesc.add("Deskripsi Beasiswa");

        dataTitle.add("Beasiswa LPJP");
        dataDesc.add("Deskripsi Beasiswa");

        dataTitle.add("Beasiswa Pertukaran Pelajar");
        dataDesc.add("Deskripsi Beasiswa");

        dataTitle.add("Beasiswa Cinta Anak");
        dataDesc.add("Deskripsi Beasiswa");

        dataTitle.add("Beasiswa Tobasa");
        dataDesc.add("Deskripsi Beasiswa");

        dataTitle.add("Beasiswa Djarum");
        dataDesc.add("Deskripsi Beasiswa");

        dataTitle.add("Beasiswa Bank Indonesia");
        dataDesc.add("Deskripsi Beasiswa");

    }
}
