package com.example.a3lab5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import static java.lang.Thread.sleep;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    int counter = 1;

    @ViewById(R.id.textView)
    TextView textView;


    @Background
    void processOnBackground(int counter) {
        int progress = 0;
        int id = counter;
        try {
            while (progress < 100) {
                progress = progress + 10;
                updateTextView(id, progress);
                sleep(3000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @UiThread
    void updateTextView(int id, int progress) {
        textView.append("\nThread: " + id + " On Progress: " + progress + "%");
        if (progress == 100) {
            textView.append("\nThread: " + id + " On_Complete");
        }
    }


    @Click(R.id.button)
    void onButtonClicked(View view) {
        processOnBackground(counter);
        counter++;
    }

}
