package com.example.mylight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    Initializing Speech Variables
    private NLPController nlpController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPermissions();                           //Getting authorizations for some permissions
        nlpController = new NLPController(getApplicationContext());
    }

    private void getPermissions(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, PackageManager.PERMISSION_GRANTED);
    }

    public void start(View view) throws InterruptedException {
        nlpController.listen();
        new CountDownTimer(5000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                order(nlpController.getListenedString());
            }

        }.start();
    }

    public void order(String command){
        Toast.makeText(this, command, Toast.LENGTH_SHORT).show();
        nlpController.speak(command);
    }

}