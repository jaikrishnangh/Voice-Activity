package com.example.jaikrishnan.voiceactivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button speak;
    ListView listView;
    static final int check = 1111;
    private String outputFile = null;
    TextView textView;
    //String[] activities = {"Events","Workshop"};
    ArrayList<String> Events = new ArrayList<String>();
    ArrayList<String> Workshops = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording123.3gp";

        speak = (Button) findViewById(R.id.sButton);
        listView = (ListView) findViewById(R.id.lv);
        textView = (TextView) findViewById(R.id.tv);
        speak.setOnClickListener(this);
        add();
    }

    private void add() {
        Events.add("event");
        Events.add("even");
        Events.add("Ivan");
        Events.add("Evan");
        Events.add("events");

        Workshops.add("ok shop");
        Workshops.add("workshop");
        Workshops.add("shop");
        Workshops.add("what's up");
        Workshops.add("Whatsapp");
        Workshops.add("whatsapp");
        Workshops.add("workshops");
    }

    @Override
    public void onClick(View v) {
        if(!isNetworkAvailable()){
            Toast.makeText(this,"Please connect With internet",Toast.LENGTH_SHORT).show();
            return;
        }

        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra("android.speech.extra.GET_AUDIO_FORMAT", "audio/AMR");
        i.putExtra("android.speech.extra.GET_AUDIO", true);
        //i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        //i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak dude!!!");
        startActivityForResult(i, check);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == check && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();

            ArrayList<String> results = bundle.getStringArrayList(RecognizerIntent.EXTRA_RESULTS);
            // the recording url is in getData:
            Uri audioUri = data.getData();
            ContentResolver contentResolver = getContentResolver();
            try {
                InputStream filestream = contentResolver.openInputStream(audioUri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
