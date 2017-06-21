package sushmenchaudhari.beacon;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;

import java.util.UUID;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.estimote.sdk.SystemRequirementsChecker;

public class MAINACTIVITY extends AppCompatActivity {
    public  BeaconManager beaconManager;
    private Region region;


    @Override
    protected void onResume() {
        super.onResume();

        SystemRequirementsChecker.checkWithDefaultDialogs(this);

        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startRanging(region);
            }
        });
    }

    @Override
    protected void onPause() {
        beaconManager.stopRanging(region);

        super.onPause();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity);

        SystemRequirementsChecker.checkWithDefaultDialogs(this);

        Button button = (Button) findViewById(R.id.scanbeacon);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = MAINACTIVITY.this;
                CharSequence text = "SCANNING FOR NEARBY BEACONS";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


                Intent myintent = new Intent(MAINACTIVITY.this, scannedBeacons.class);
                startActivity(myintent);


            }

        });

        beaconManager = new BeaconManager(this);
        Region ranged_region = new Region("ranged_region",
                UUID.fromString("12345abc-b644-4520-8f0c-720eaf059935"), null, null);

    }

}
