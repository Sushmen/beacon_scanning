package sushmenchaudhari.beacon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;

import java.util.UUID;

/**
 * Created by Kailas Chaudhari on 08-03-2017.
 */

public class scannedBeacons extends MAINACTIVITY{

    private BeaconManager beaconmanager;

    public void onCreate(Bundle savedInstanceStates){

        super.onCreate(savedInstanceStates);

        setContentView(R.layout.scanned_beacons);


        beaconmanager = new BeaconManager(getApplicationContext());

        beaconmanager.connect(new BeaconManager.ServiceReadyCallback(){


            public void onServiceReady(){

                beaconmanager.startMonitoring(new Region(
                        "monitored region",
                        UUID.fromString("12345abc-b644-4520-8f0c-720eaf059935"),
                        79797,97979
                ));

            }
        });
    }
}
