package com.udacity.gradle.builditbigger.asynctask;

import android.app.Activity;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.listener.EndPointListener;
import com.udacity.gradle.builditbigger.util.ProgressBarHandler;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * Created by Naveen on 4/15/2018.
 */

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private EndPointListener endPointListener;

    private ProgressBarHandler progressBarHandler;

    public EndpointsAsyncTask(Activity activity, EndPointListener endPointListener) {
        this.progressBarHandler = new ProgressBarHandler(activity);
        this.endPointListener = endPointListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(progressBarHandler != null)
            progressBarHandler.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getRandomJoke().execute().getData();
        } catch (IOException e) {
            return null;
        }
    }



    @Override
    protected void onPostExecute(String result) {
        if(progressBarHandler != null) {
            progressBarHandler.hide();
        }
        if(endPointListener != null){
            endPointListener.onEndPointResult(result);
        }
    }
}