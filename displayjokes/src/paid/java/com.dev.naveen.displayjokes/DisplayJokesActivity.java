package com.dev.naveen.displayjokes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dev.naveen.displayjokes.util.ProgressBarHandler;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by Naveen on 4/15/2018.
 */

public class DisplayJokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diaplay_jokes_activity);

        String newjoke = null;

        Bundle bn = getIntent().getExtras();
        if(bn != null){
            if(bn.containsKey(Constants._KEY_JOKES_)){
                newjoke = bn.getString(Constants._KEY_JOKES_);
            }
        }

        final TextView tvNewJoke = findViewById(R.id.tvNewJoke);
        if (newjoke != null && newjoke.length() > 0) {
            tvNewJoke.setText(newjoke);
        }


    }

}
