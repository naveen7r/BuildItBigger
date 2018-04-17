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

    private InterstitialAd interstitialAd;
    private ProgressBarHandler progressBarHandler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diaplay_jokes_activity);


        initInteritialAd();

        String newjoke = null;

        Bundle bn = getIntent().getExtras();
        if(bn != null){
            if(bn.containsKey(Constants._KEY_JOKES_)){
                newjoke = bn.getString(Constants._KEY_JOKES_);
            }
        }

        final TextView tvNewJoke = findViewById(R.id.tvNewJoke);

        tvNewJoke.setVisibility(View.GONE);
        if (newjoke != null && newjoke.length() > 0) {
            tvNewJoke.setText(newjoke);
        } else {
            tvNewJoke.setText(getString(R.string.error_message));
        }

        progressBarHandler = new ProgressBarHandler(this);
        progressBarHandler.show();

        if(interstitialAd != null) {
            interstitialAd.setAdListener(new AdListener() {


                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    interstitialAd.show();
                    progressBarHandler.hide();

                }

                @Override
                public void onAdClosed() {
                    // Load the next interstitial.
                    tvNewJoke.setVisibility(View.VISIBLE);
                }

            });
        }


    }


    private void initInteritialAd(){
        MobileAds.initialize(this,
                getString(com.dev.naveen.displayjokes.R.string.interstitial_ad_unit_id));

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(com.dev.naveen.displayjokes.R.string.ad_unit_id));
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        interstitialAd.loadAd(adRequest);
    }
}
