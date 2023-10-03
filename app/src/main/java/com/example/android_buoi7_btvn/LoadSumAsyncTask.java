package com.example.android_buoi7_btvn;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadSumAsyncTask extends AsyncTask<Void, Integer, Long> {

    private ProgressBar progressBar;
    private TextView tvResult;
    private ILoadSumListener iLoadSumListener;

    public LoadSumAsyncTask(ProgressBar pbLoading, TextView tvResult) {
        this.progressBar = pbLoading;
        this.tvResult = tvResult;
    }

    public void setILoadSumListener(ILoadSumListener iLoadSumListener) {
        this.iLoadSumListener = iLoadSumListener;
    }

    @Override
    protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);
        if (aLong > 0) {
            progressBar.setProgress(100);
            tvResult.setText("Tong tu 1 -> 3 trieu la: " + aLong);
            iLoadSumListener.onLoadSumSuccess(aLong);
        } else {
            iLoadSumListener.onLoadSumError("Error");
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setProgress(0);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
    }

    @Override
    protected Long doInBackground(Void... voids) {
        long sum = 0;
        int n = 3000000;
        for (int i=1; i<=n; i++) {
            sum += i;
            int progress = (i/n) * 100;
            publishProgress(progress);
        }
        return sum;
    }
}
