package perfectly.balanced.as_all_things_should_be;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.inmobi.sdk.InMobiSdk;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    static String TAG = "PERFBALANCE";




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Set to debug level
        InMobiSdk.setLogLevel(InMobiSdk.LogLevel.DEBUG);
        InMobiSdk.init(this, "4028cb8b2c3a0b45012c406824e800ba"); // must call this method on the UI thread.

        setContentView(R.layout.activity_main);



        Button showAd = (Button) findViewById(R.id.showBanner);
        showAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InfinityGauntlet.class));
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Create a new consent object
   //      JSONObject consentObject = new JSONObject();

//        try {
//            // Provide correct consent value to sdk which is obtained by User
//            consentObject.put(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE, true);
//            // Provide 0 if GDPR is not applicable and 1 if applicable
//            consentObject.put("gdpr", "0");
//            Log.d(TAG, "GDPR set to" + consentObject.get("gdpr"));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

}
