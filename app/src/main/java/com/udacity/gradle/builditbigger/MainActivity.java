package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dev.naveen.displayjokes.Constants;
import com.dev.naveen.displayjokes.DisplayJokesActivity;
import com.udacity.gradle.builditbigger.asynctask.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.listener.EndPointListener;


public class MainActivity extends AppCompatActivity  {

    private EndpointsAsyncTask endpointsAsyncTask;
    private EndPointListener endPointListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        endPointListener = new EndPointListener() {
            @VisibleForTesting
            @Override
            public void onEndPointResult(String result) {
                if(result == null){
                    Toast.makeText(MainActivity.this, getString(R.string.error_occured), Toast.LENGTH_LONG).show();
                } else {
                   launchDisplayJokeActivity(result);
                }
            }
        };
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

       /* //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        endpointsAsyncTask = new EndpointsAsyncTask(this, endPointListener);
        endpointsAsyncTask.execute();
    }

    private void launchDisplayJokeActivity(String result) {
        Intent launchDisplayJokesActivity = new Intent(this, DisplayJokesActivity.class);
        launchDisplayJokesActivity.putExtra(Constants._KEY_JOKES_, result);
        startActivity(launchDisplayJokesActivity);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public EndPointListener getEndPointListener() {
        return endPointListener;
    }

    public void setEndPointListener(EndPointListener endPointListener) {
        this.endPointListener = endPointListener;
    }

    @Override
    protected void onDestroy() {
        if (endpointsAsyncTask != null) {
            endpointsAsyncTask.cancel(true);
            endpointsAsyncTask = null;
        }
        endPointListener = null;
        super.onDestroy();
    }


}
