package com.sample.banner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

public class BannerActivity extends AppCompatActivity {

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        // Instantiate an AdView view
        adView = new AdView(this, "YOUR_PLACEMENT_ID", AdSize.BANNER_HEIGHT_50);

        // Find the Ad container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to container
        adContainer.addView(adView);

        adView.setAdListener(new AdListener() {

            @Override
            public void onError(Ad ad, AdError adError) {
                Toast.makeText(BannerActivity.this, "Error: " + adError.getErrorMessage(), Toast
                    .LENGTH_LONG).show();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Toast.makeText(BannerActivity.this, "Ad loaded!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                Toast.makeText(BannerActivity.this, "Ad clicked!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Toast.makeText(BannerActivity.this, "Impression logged!", Toast.LENGTH_LONG).show();
            }
        });

        // Request an ad
        adView.loadAd();
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}
