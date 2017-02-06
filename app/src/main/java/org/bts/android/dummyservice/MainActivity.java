package org.bts.android.dummyservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private CustomBoundService mCustomBoundService;
    private TextView mTvInfo;
    private EditText mEtInput;
    private boolean mIsBound;
    private ServiceConnection mServConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder serviceInfo) {
            mCustomBoundService = new CustomBoundService(serviceInfo);
            mIsBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mIsBound = false;

        }
    };

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

        this.mTvInfo = (TextView) findViewById(R.id.textView2);
        this.mEtInput = (EditText) findViewById(R.id.editText);
    }

    @Override
    public void onClick(View whichView) {

        switch (whichView.getId()) {

            case R.id.start_service:
                Log.w(MainActivity.TAG, "Service Started");
                Intent StartServiceIntent = new Intent(this, CustomStartedService.class);
                startService(StartServiceIntent);
                break;

            case R.id.start_bound_service:
                Log.w(MainActivity.TAG, "Bound Service Started");
                Intent BoundServiceIntent = new Intent(this, CustomBoundService.class);
                bindService(BoundServiceIntent, mServConnection, Context.BIND_AUTO_CREATE);
                break;

            case R.id.start_intent_service:
                Log.w(MainActivity.TAG, "IntentService Started");
                Intent CustomServiceIntent = new Intent(this, CustomIntentService.class);
                startService(CustomServiceIntent);
                break;

            case R.id.go_input_field:
                Log.w(MainActivity.TAG, "Go Input Button Clicked");
                
                if (this.mIsBound) {
                    int numberReturn = this.mCustomBoundService.getRandomNumber();
                    this.mTvInfo.setText(Integer.toString(numberReturn));
                }
                else {
                    Toast.makeText(this, "Bound Service not Started", Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                Log.w(MainActivity.TAG, "Something else Clicked");
                break;

        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(this.mServConnection);
    }
}
