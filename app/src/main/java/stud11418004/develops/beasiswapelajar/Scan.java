package stud11418004.develops.beasiswapelajar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.huawei.hms.ml.scan.HmsScan;

public class Scan extends Activity {

    public static final int DEFINED_CODE = 222;

    private static final int REQUEST_CODE_SCAN = 0X01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
    }


    public void newViewBtnClick(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.requestPermissions(
                    new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE},
                    DEFINED_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (permissions == null || grantResults == null || grantResults.length < 2 || grantResults[0] != PackageManager.PERMISSION_GRANTED || grantResults[1] != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        if (requestCode == DEFINED_CODE) {
            //start your activity for scanning barcode
            this.startActivityForResult(new Intent(this, DefinedActivity.class), REQUEST_CODE_SCAN);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //receive result after your activity finished scanning
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK || data == null) {
            return;
        }
        if (requestCode == REQUEST_CODE_SCAN) {
            HmsScan hmsScan = data.getParcelableExtra(DefinedActivity.SCAN_RESULT);
            if (hmsScan != null && !TextUtils.isEmpty(hmsScan.getOriginalValue())) {
                Toast.makeText(Scan.this, hmsScan.getOriginalValue(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
