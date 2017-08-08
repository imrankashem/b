package com.example.imran.doctorscorner.ambulance;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.imran.doctorscorner.R;

/**
 * Created by imran on 7/17/2017.
 */

public class ambulance1 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ambulance1);
    }
    public void uphandler(View v){
        this.finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
        // This will kill current activity, and if previous activity is still opened in background, it will come in front.
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
