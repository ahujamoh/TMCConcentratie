package concentration.tmc.ahujamoh.com.tmc_concentratie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import concentration.tmc.ahujamoh.com.tmc_concentratie.R;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Launched main activity");
    }

    public void beginGame(View v) {
    Intent intent = new Intent(this, GameActivity.class);
    startActivity(intent);
    }
}
