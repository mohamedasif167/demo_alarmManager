package com.example.a15017498.demo_alarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAlarm;
    AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnAlarm = (Button) findViewById(R.id.btnSetAlarm);

        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND,5);


                //Creating a new PendingIntent
                Intent intent = new Intent(MainActivity.this,AlarmReceiverActivity.class);
                int reqCode = 12345;
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,reqCode,intent,PendingIntent.FLAG_CANCEL_CURRENT);

                //Get AlarmManager Instance
                am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);

                //Setting the alarm
                am.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pendingIntent);

            }
        });

    }
}
