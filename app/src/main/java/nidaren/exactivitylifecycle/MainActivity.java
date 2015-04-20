package nidaren.exactivitylifecycle;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends ActionBarActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    public TextView textView;
    public SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    //public Date date = new Date();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.information);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        Log.v(TAG,"onCreate");
        textView.setText(sdf.format(new Date()) + " oncreate\n");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


     @Override
   protected void onStart() {
        super.onStart();
        Log.v(TAG, "onStart");
        TextView textView = (TextView) findViewById(R.id.information);
        textView.append(sdf.format(new Date()) + " onStart\n");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "onRestart");
        TextView textView = (TextView) findViewById(R.id.information);
        textView.append(sdf.format(new Date()) + " onRestart\n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResume");
        TextView textView = (TextView) findViewById(R.id.information);
        textView.append(sdf.format(new Date()) + " onResume\n");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"onPause");
        TextView textView = (TextView) findViewById(R.id.information);
        textView.append(sdf.format(new Date()) + " onPause\n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"onStop");
        TextView textView = (TextView) findViewById(R.id.information);
        textView.append(sdf.format(new Date()) + " onStop\n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestory");
        TextView textView = (TextView) findViewById(R.id.information);
        textView.append(sdf.format(new Date()) + " onDestory\n");
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

    }

}
