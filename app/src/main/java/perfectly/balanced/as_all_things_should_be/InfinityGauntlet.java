package perfectly.balanced.as_all_things_should_be;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.RelativeLayout;


import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiBanner;

import java.util.Map;


public class InfinityGauntlet extends AppCompatActivity  {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    static String TAG = "PERFBALANCE";
    private InMobiBanner mBannerAd;

    String [] myDataSet = new String [] {"glow stick","sofa","remote","seat belt","chocolate","doll","nail clippers","cookie jar","car","slipper","shovel","clay pot","buckel","headphones","shoes","keyboard","shoe lace","bananas","twezzers","controller","lip gloss","CD","vase","pen","blouse","glass","pencil","mouse pad","hanger","toothbrush","radio","tv","mp3 player","canvas","chapter book","cell phone","sand paper","tissue box","cat","stop sign","chalk","thread","candle","toe ring","air freshener","teddies","bag","eye liner","checkbook","scotch tape","lamp","conditioner","television","floor","book","ring","street lights","screw","twister","clamp","pants","towel","playing card","box","washing machine","truck","couch","shawl","white out","stockings","bow","grid paper","shampoo","cup","perfume","button","cork","photo album","spoon","sailboat","leg warmers","packing peanuts","monitor","candy wrapper","tooth picks","soy sauce packet","fork","paint brush","clock","model car","socks","clothes","credit card","ipod","needle","hair tie","zipper","bottle","plate","mop"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinity_gauntlet);

        // Find recycler view in XML
        mRecyclerView = findViewById(R.id.my_recycler_view);
        // mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

        mAdapter = new MyAdapter(myDataSet);
        mRecyclerView.setAdapter(mAdapter);

        // Log.d(TAG, "Init SDK");
        // Get ref to adcontainer
        RelativeLayout adContainer = (RelativeLayout) findViewById(R.id.ad_container);

        setupBannerAd(); // loads mBanner
        Log.d(TAG, "On create finished");


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
