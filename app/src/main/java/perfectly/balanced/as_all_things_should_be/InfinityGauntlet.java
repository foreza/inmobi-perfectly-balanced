package perfectly.balanced.as_all_things_should_be;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;


import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.sdk.InMobiSdk;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;


public class InfinityGauntlet extends AppCompatActivity {

    static String TAG = "PERFBALANCE";

    private InMobiBanner bannerAd;
    private InMobiBanner mBannerAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "On create called");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinity_gauntlet);


        // Log.d(TAG, "Init SDK");
        // Get ref to adcontainer
            RelativeLayout adContainer = (RelativeLayout) findViewById(R.id.ad_container);


        setupBannerAd(); // loads mBanner

    }


    private void setupBannerAd() {
        mBannerAd = new InMobiBanner(InfinityGauntlet.this, 1516349281162L);
         RelativeLayout adContainer = (RelativeLayout) findViewById(R.id.ad_container);
        mBannerAd.setAnimationType(InMobiBanner.AnimationType.ROTATE_HORIZONTAL_AXIS);
        mBannerAd.setListener(new InMobiBanner.BannerAdListener() {
            @Override
            public void onAdLoadSucceeded(InMobiBanner inMobiBanner) {
                Log.d(TAG, "onAdLoadSucceeded");
            }

            @Override
            public void onAdLoadFailed(InMobiBanner inMobiBanner,
                                       InMobiAdRequestStatus inMobiAdRequestStatus) {
                Log.d(TAG, "Banner ad failed to load with error: " +
                        inMobiAdRequestStatus.getMessage());
            }

            @Override
            public void onAdDisplayed(InMobiBanner inMobiBanner) {
                Log.d(TAG, "onAdDisplayed");
            }

            @Override
            public void onAdDismissed(InMobiBanner inMobiBanner) {
                Log.d(TAG, "onAdDismissed");
            }

            @Override
            public void onAdInteraction(InMobiBanner inMobiBanner, Map<Object, Object> map) {
                Log.d(TAG, "onAdInteraction");
            }

            @Override
            public void onUserLeftApplication(InMobiBanner inMobiBanner) {
                Log.d(TAG, "onUserLeftApplication");
            }

            @Override
            public void onAdRewardActionCompleted(InMobiBanner inMobiBanner, Map<Object, Object> map) {
                Log.d(TAG, "onAdRewardActionCompleted");
            }
        });
        setBannerLayoutParams();
         adContainer.addView(mBannerAd);
        mBannerAd.load();
    }

    private void setBannerLayoutParams() {
        int width = toPixelUnits(320);
        int height = toPixelUnits(50);
        RelativeLayout.LayoutParams bannerLayoutParams = new RelativeLayout.LayoutParams(width, height);
        bannerLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        bannerLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        mBannerAd.setLayoutParams(bannerLayoutParams);
    }

    private int toPixelUnits(int dipUnit) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dipUnit * density);
    }


}
