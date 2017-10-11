package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BastActivity extends AppCompatActivity {
    private OffBroadCastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollecor.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter =new IntentFilter();
        filter.addAction("com.example.broadcastreceiver.OFFALL");
        receiver = new OffBroadCastReceiver();
        registerReceiver(receiver,filter);
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (receiver!=null){
            unregisterReceiver(receiver);
            receiver = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollecor.removeActivity(this);
    }
    class OffBroadCastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder builder =new AlertDialog.Builder(context);
            builder.setTitle("提示");
            builder.setMessage("您要被强制退出了！");
            builder.setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollecor.finshAll();
                    Intent intent = new Intent(context,LoginActivity.class);
                    context.startActivity(intent);
                }
            });
            builder.show();
        }
    }
}
