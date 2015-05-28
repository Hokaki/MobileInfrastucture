package com.example.alwin.androidsensors;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;


public class MySensorActivity extends ActionBarActivity implements SensorEventListener {

    private TextView tv;
    private SensorManager mSensorManager;
    private Sensor mSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sensor);

        tv= (TextView)findViewById(R.id.txt2);
        // Get an instance of the sensor service
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //Vervang hieronder TYPE_GYROSCOPE door TYPE_LIGHT om gebruik te maken van de light of Gyroscope sensor
        mSensor=mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        PackageManager PM= this.getPackageManager();
        boolean gyro = PM.hasSystemFeature(PackageManager.FEATURE_SENSOR_GYROSCOPE);
        boolean light = PM.hasSystemFeature(PackageManager.FEATURE_SENSOR_LIGHT);

        if(gyro){

            if(light){
                Toast.makeText(getApplicationContext(),"Both light and gyroscope sensors are present", Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(getApplicationContext(),"Only gyroscope sensor is present", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {

        float angularXSpeed = event.values[0];
        tv.setText("Angular X speed level is: " + "" + angularXSpeed);
    }

    @Override
    protected void onResume() {
        // Register a listener for the sensor.
        super.onResume();
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // important to unregister the sensor when the activity pauses.
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

}