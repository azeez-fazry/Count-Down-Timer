package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textViewTimer;
    TextView textViewTimeElapsed;

    Button buttonResetTime;

    private final long startTime = 5 * 1000;
    private final long interval = 1 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTimer = (TextView) findViewById(R.id.TextView_Time);
        textViewTimeElapsed = (TextView) findViewById(R.id.TextView_TimeElapsed);
        buttonResetTime = (Button) findViewById(R.id.Button_ResetTime);

        final CountDownTimer countDownTimer = new CountDownTimer(startTime, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewTimer.setText("Time: " + millisUntilFinished / 1000);
                textViewTimeElapsed.setText("Time Elapsed: " + (startTime - millisUntilFinished)/1000 );
            }

            @Override
            public void onFinish() {
                textViewTimer.setText("Timer Finished");
            }
        };
        countDownTimer.start();


        buttonResetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                countDownTimer.start();

            }
        });



    }
}