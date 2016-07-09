package com.futa.romannumtrans;

// 呼び出し方
//      Intent intent = new Intent(this, BeenoActivity.class);
//      startActivity(intent);

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BeenoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beeno);
    }
}
