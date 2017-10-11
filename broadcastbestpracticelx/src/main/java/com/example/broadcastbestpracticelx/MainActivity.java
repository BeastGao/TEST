package com.example.broadcastbestpracticelx;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {
    private Button offActivityAll ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        offActivityAll = (Button) findViewById(R.id.offall_btn);
        offActivityAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("con.example.broadcastbestpracticelx.OFFACTIVITYALL");
                sendBroadcast(intent);

            }
        });
    }
}
