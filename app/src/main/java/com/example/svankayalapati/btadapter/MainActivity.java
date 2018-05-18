package com.example.svankayalapati.btadapter;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {

    private BluetoothAdapter btAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Register the BroadcastReceiver
       // IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        //filter.addAction(BluetoothDevice.ACTION_UUID);
       // filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
       // filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        //  registerReceiver(ActionFoundReceiver, filter); // Don't forget to unregister during onDestroy

        btAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean ret = btAdapter.enable();
        Toast.makeText(getApplicationContext(),"BT enabled returned" + ret,Toast.LENGTH_SHORT ).show();

        CheckBTState();

        ret = btAdapter.disable();
        Toast.makeText(getApplicationContext(),"BT disable returned" + ret,Toast.LENGTH_SHORT ).show();
        CheckBTState();
    }

    private void CheckBTState() {
        // Check for Bluetooth support and then check to make sure it is turned on
        // If it isn't request to turn it on
        // List paired devices
        // Emulator doesn't support Bluetooth and will return null
        if(btAdapter==null) {
            out.append("\nBluetooth NOT supported. Aborting.");
            return;
        } else {
            if (btAdapter.isEnabled()) {

                Toast.makeText(getApplicationContext(),"BT is enabled",Toast.LENGTH_SHORT ).show();

            } else {
                Toast.makeText(getApplicationContext(),"BT is not enabled",Toast.LENGTH_SHORT ).show();
        // Intent enableBtIntent = new Intent(btAdapter.ACTION_REQUEST_ENABLE);
        // startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
        }
    }
}
