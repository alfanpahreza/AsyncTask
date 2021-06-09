package com.example.asynctask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TEXT_STATE = "currentText";

    private TextView mTextView1 = null;
    private TextView mTextView2 = null;
    private Button startButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView1 = findViewById(R.id.textView1);
        mTextView2 = findViewById(R.id.textView2);
        startButton = findViewById(R.id.button);

        startButton.setOnClickListener(startButtonListener);

        if(savedInstanceState!=null){
            mTextView1.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    private View.OnClickListener startButtonListener = new View.OnClickListener(){
        public void onClick(View v){
            mTextView1.setText(null);
            mTextView2.setText(null);
            new SimpleAsyncTask(mTextView1,mTextView2).execute();
        }
    };

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_STATE, mTextView1.getText().toString());
    }
}