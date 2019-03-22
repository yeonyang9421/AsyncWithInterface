package kr.co.woobi.imyeon.asyncwithinterface;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class TimerFragment extends Fragment {
    public TextView mTextTime;
    private Button mButtonStart, mButtonInitialization;
    private Animation mShake;
    public interface onTimeClickListener {
        void onStartTimeClick();

        void onCancelTimeClick(boolean flag);
    }

    onTimeClickListener mListener;

    public void setOnTimeClickListener(onTimeClickListener listener) {
        mListener = listener;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        mTextTime = view.findViewById(R.id.text_fragment_time);

        mButtonStart = view.findViewById(R.id.button_start);
        mButtonInitialization = view.findViewById(R.id.button_initialization);

        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mCountTask.execute(0);
                mListener.onStartTimeClick();

            }
        });

        mButtonInitialization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextTime.setText("0");
//                mCountTask.cancel(true);
                mListener.onCancelTimeClick(true);
            }
        });
        return view;
    }

}
