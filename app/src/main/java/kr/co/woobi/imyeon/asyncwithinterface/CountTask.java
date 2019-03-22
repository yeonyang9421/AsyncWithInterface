package kr.co.woobi.imyeon.asyncwithinterface;

import android.os.AsyncTask;

public class CountTask extends AsyncTask<Integer, Integer, Integer> {

    public interface onSendTimeListener {
        void onSendTime(Integer... time);
    }

    onSendTimeListener mListener;

    public void setOnSendTimeListener(onSendTimeListener listener) {
        mListener = listener;
    }

    @Override
    protected Integer doInBackground(Integer... params) {
        for (int i = 1; i < 10; i++) {
            try {
                Thread.sleep(1000);
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mListener.onSendTime(values[0]);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }
}
