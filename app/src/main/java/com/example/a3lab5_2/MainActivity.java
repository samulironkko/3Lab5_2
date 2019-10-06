package com.example.a3lab5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.UiThread;


public class MainActivity extends AppCompatActivity implements MyThread.MyInterface, View.OnClickListener {

    int counter = 1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        textView = findViewById(R.id.textView);
    }

    @UiThread
    public void updateStatus(final int progress, final int id) {
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.append("\nThread: " + id + " On Progress: " + progress + "%");
                if (progress == 100) {
                    textView.append("\nThread: " + id + " On_Complete");
                }
            }
        });
    }

    public void startThread() {
        //threads[counter] = new MyThread(this, counter);
        //threads[counter].start();
        MyThread myThread = new MyThread(this, counter);
        myThread.start();
        textView.append("\nNew thread created with Id:" + counter);
        counter++;
    }

    @Override
    public void onClick(View v) {
        startThread();
    }
}
