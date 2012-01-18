
package org.zakky.async15;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

public class Async15Activity extends Activity {
    final Async15Activity self = this;

    private static final String TAG = Async15Activity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        new AsyncTask<Void, Void, Void>() {
            private ProgressDialog mProgress;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                mProgress = new ProgressDialog(self);
                mProgress.setIndeterminate(true);
                mProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                mProgress.setMessage("おためしか");
                mProgress.setCancelable(false);
                mProgress.show();
            }

            @Override
            protected Void doInBackground(Void... params) {
                Log.d(TAG, "enter doInBackground()");
                for (int i = 0; i < 10; i++) {
                    SystemClock.sleep(1000L);
                    Log.d(TAG, "doInBackground(): " + i);
                }
                Log.d(TAG, "exit doInBackground()");

                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                super.onPostExecute(result);

                mProgress.dismiss();
            }

        }.execute();

    }
}
