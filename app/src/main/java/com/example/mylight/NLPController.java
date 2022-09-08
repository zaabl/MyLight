package com.example.mylight;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;

import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.Locale;

public class NLPController {

    private SpeechRecognizer speechRecognizer;
    private Intent intentRecognizer;
    private TextToSpeech textToSpeech;
    private android.content.Context context;
    private String listenedString = "";

    public NLPController(android.content.Context context) {
        this.context = context;
        initializeSpeechToText();
        initializeTextToSpeech();
    }

    private void initializeTextToSpeech(){
        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                }
            }
        });
    }

    public void speak(final String word){

        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int arg0) {
                if(arg0 == TextToSpeech.SUCCESS)
                {
                    textToSpeech.setLanguage(Locale.US);
                    textToSpeech.speak(word, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });
    }

    private void initializeSpeechToText(){
        intentRecognizer = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intentRecognizer.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(context);
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {

            }

            @Override
            public void onResults(Bundle results) {
                ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if(matches != null){
                    listenedString = matches.get(0);
                }
                else{
                    listenedString = "null";
                }


            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });
    }

    public void listen() throws InterruptedException {
        speechRecognizer.startListening(intentRecognizer);
    }

    public String getListenedString() {
        return listenedString;
    }
}
