package concentration.tmc.ahujamoh.com.tmc_concentratie.Activities;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import concentration.tmc.ahujamoh.com.tmc_concentratie.ImageDownloader.FlickrAPIEndpoints;
import concentration.tmc.ahujamoh.com.tmc_concentratie.ImageDownloader.RetrofitFlickrAPIClient;
import concentration.tmc.ahujamoh.com.tmc_concentratie.Models.Gallery;
import concentration.tmc.ahujamoh.com.tmc_concentratie.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GameActivity extends AppCompatActivity {
    public static final String TAG = GameActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private TextView mScoreTextView;
    private Chronometer mChronometer;
    private ProgressBar mProgressBar;
    private ConstraintLayout mConstraintLayout;

    private Call<Gallery> mGalleryCall;

    @Override
    public void onDestroy(){
        super.onDestroy();
        //Stop the gallery fetch call
        if (mGalleryCall != null && mGalleryCall.isExecuted())
            mGalleryCall.cancel();

    }

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
        Log.v(TAG, "call retrofit to fetch images here"); //TODO: call retrofit

        mGalleryCall = RetrofitFlickrAPIClient.call(FlickrAPIEndpoints.class).getPhotosForQuery("cats", 8, 1);
        mGalleryCall.enqueue(new Callback<Gallery>() {
            @Override
            public void onResponse(Call<Gallery> call, Response<Gallery> response) {
                if (response.isSuccessful()){

                    Gallery gallery = response.body();
                    if (gallery != null){

                        Gallery.Photos photos = gallery.getPhotos();
                        if(photos != null){
                            Log.v(TAG, "response was successful");
                            List<Gallery.Photo> photoList1 = photos.getPhotos();
                            List<Gallery.Photo> photoList2 = new ArrayList<Gallery.Photo>(photoList1);

                            Collections.shuffle(photoList1);
                            Collections.shuffle(photoList2);

                            List<Gallery.Photo> combinedList = new ArrayList<Gallery.Photo>(photoList1);
                            combinedList.addAll(photoList2);

                            Collections.shuffle(combinedList);

                        }
                    }
                    else{
                        Log.e(TAG, "response was not successful");
                    }
                }
            }

            @Override
            public void onFailure(Call<Gallery> call, Throwable t) {
                Log.e(TAG, t.getLocalizedMessage());
            }
        });
    }
}
