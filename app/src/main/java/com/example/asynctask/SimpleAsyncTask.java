package com.example.asynctask;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Integer,Integer,String> {

    private WeakReference<TextView> mTextView1;
    private WeakReference<TextView> mTextView2;

    Integer count = 1;
    int s = 0;

    SimpleAsyncTask(TextView tv,TextView tt) {
        mTextView1 = new WeakReference<>(tv);
        mTextView2 = new WeakReference<>(tt);

        Random r = new Random();
        int n = r.nextInt(11);
        s = n * 200;
    }

    //Proses yang dilakukan dibelakang proses utama
    @Override
    protected String doInBackground(Integer... params) {
        try {
            publishProgress(s);
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    @Override
    protected void onPostExecute(String result) {
        mTextView1.get().setText(result);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        mTextView2.get().setText("Sleep Time :" + s + " milliseconds");
    }
}
