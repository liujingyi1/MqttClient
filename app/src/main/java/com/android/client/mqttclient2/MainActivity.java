package com.android.client.mqttclient2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.client.mqtt.IClientCallback;
import com.android.server.mqtt.IMqttService;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    IMqttService mqttService;

    Button button;
    Button fasongButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.dingyue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mqttService != null) {
                    try {
                        Log.i("jingyi", "subscribe mqttCallback="+mqttCallback);
                        mqttService.subscribeTopic(MqttTopics.FACE_ADD, mqttCallback);
                    } catch (Exception e) {
                        Log.i("jingyi", "subscribe e="+e.getMessage());
                    }
                } else {
                    Log.i("jingyi", "subscribe mqttService="+mqttService);
                }
            }
        });

        fasongButton = (Button)findViewById(R.id.fasong);
        fasongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mqttService != null) {
                    try {
                        mqttService.publish(MqttTopics.UPLOAD_ACCESS_LOG, "一个 faceId");
                    } catch (Exception e) {
                        Log.i("jingyi", "publish e="+e.getMessage());
                    }
                } else {
                    Log.i("jingyi", "publish mqttService="+mqttService);
                }
            }
        });

        LinkedList

        Intent intent = new Intent();
        intent.setAction("com.android.server.mqtt.IMqttService");
        intent.setPackage("com.android.server.mqttservice");
        intent.putExtra("from", "diyigeClient");
        startService(intent);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    IClientCallback mqttCallback = new IClientCallback.Stub() {
        @Override
        public void dispatch(String topic, String content){
            Log.i("jingyi", "topic="+topic+" content="+content);
            try {
                Thread.sleep(10*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i("jingyi", "............");

        }
    };

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mqttService = IMqttService.Stub.asInterface(iBinder);
            Log.i("jingyi", "onServiceConnected...");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
