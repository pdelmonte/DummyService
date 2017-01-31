package org.bts.android.dummyservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnStartService = (Button) findViewById(R.id.start_service);
        btnStartService.setOnClickListener(this);

        final Button btnStartBoundService = (Button) findViewById(R.id.start_bound_service);
        btnStartBoundService.setOnClickListener(this);

        final Button btnStartIntentService = (Button) findViewById(R.id.start_intent_service);
        btnStartIntentService.setOnClickListener(this);

        final Button btnGoInputField = (Button) findViewById(R.id.go_input_field);
        btnGoInputField.setOnClickListener(this);
    }

    @Override
    public void onClick(View whichView) {

        switch (whichView.getId()) {

            case R.id.start_service:
                Log.w(MainActivity.TAG, "Service Started");
                break;

            case R.id.start_bound_service:
                Log.w(MainActivity.TAG, "Bound Service Started");
                break;

            case R.id.start_intent_service:
                Log.w(MainActivity.TAG, "IntentService Started");
                break;

            default:
                Log.w(MainActivity.TAG, "Something else Clicked");
                break;

        }

    }


}
