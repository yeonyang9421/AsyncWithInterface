package kr.co.woobi.imyeon.asyncwithinterface;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CountTask.onSendTimeListener, TimerFragment.onTimeClickListener {
    private TextView mTextTime;
    private CountTask mCountTask;
    private TimerFragment mTimerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextTime = findViewById(R.id.text_activity_time);
       mTimerFragment = (TimerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
       mTimerFragment.setOnTimeClickListener(this);

    }

    @Override
    public void onStartTimeClick() {
        mCountTask = new CountTask();
        mCountTask.setOnSendTimeListener(this);
        mCountTask.execute();
    }

    @Override
    public void onCancelTimeClick(boolean flag) {
        mCountTask.cancel(flag);
        mTextTime.setText("0");
    }

    @Override
    public void onSendTime(Integer... time) {
        mTextTime.setText(String.valueOf(time[0]));
        mTimerFragment.mTextTime.setText(String.valueOf(time[0]));
    }
}
