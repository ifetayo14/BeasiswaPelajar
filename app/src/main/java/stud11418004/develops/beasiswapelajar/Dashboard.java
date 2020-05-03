package stud11418004.develops.beasiswapelajar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    Button beasiswaBtn;
    Button savedBtn;
    Button appliedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        beasiswaBtn = findViewById(R.id.beasiswaBtn);
        savedBtn = findViewById(R.id.savedBtn);
        appliedBtn = findViewById(R.id.appliedBtn);

        beasiswaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, BeasiswaActivity.class);
                startActivity(intent);
            }
        });

        savedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, SavedBeasiswaActivity.class);
                startActivity(intent);
            }
        });

        appliedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, AppliedBeasiswaActivity.class);
                startActivity(intent);
            }
        });
    }
}
