package concentration.tmc.ahujamoh.com.tmc_concentratie.Activities;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.TextView;

import concentration.tmc.ahujamoh.com.tmc_concentratie.R;

public class GameActivity extends AppCompatActivity {
    public static final String TAG = GameActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private TextView mScoreTextView;
    private Chronometer mChronometer;
    private ProgressBar mProgressBar;
    private ConstraintLayout mConstraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        setUpWidgetVariables();

        getImages();

    }

    private void setUpWidgetVariables() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView); //TODO: set up adapter
        mScoreTextView = (TextView) findViewById(R.id.score_textview);
        mChronometer = (Chronometer) findViewById(R.id.chronometer);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mConstraintLayout = (ConstraintLayout) findViewById(R.id.gameConstraintLayout);
    }

    private void getImages(){
        Log.v(TAG, "call retrofit to fetch images here");
    }
}
