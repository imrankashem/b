package com.example.imran.doctorscorner;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by imran on 6/16/2017.
 */

public class comilladoc3 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comilla_doc3);
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
