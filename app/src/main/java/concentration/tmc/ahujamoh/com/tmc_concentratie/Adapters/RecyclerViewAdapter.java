package concentration.tmc.ahujamoh.com.tmc_concentratie.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import concentration.tmc.ahujamoh.com.tmc_concentratie.Models.Gallery;
import concentration.tmc.ahujamoh.com.tmc_concentratie.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewCell> {
    private Context mContext;
    private List<Gallery.Photo> mPhotoList;
    public RecyclerViewAdapter(Context context){
        mContext = context;
        mPhotoList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerViewCell onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item, viewGroup, false);
        return new RecyclerViewCell(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewCell recyclerViewCell, int i) {
        Gallery.Photo photo = mPhotoList.get(i);
        recyclerViewCell.bind(photo);
    }

    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }

    public void setPhotoList(List<Gallery.Photo> photoList) {
        mPhotoList = photoList;
        notifyDataSetChanged();
    }

    public class RecyclerViewCell extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Gallery.Photo mPhoto;
        private ImageView mImageView;

        public RecyclerViewCell(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
        }

        public void bind(Gallery.Photo photo) {
            mPhoto = photo;
        }

        @Override
        public void onClick(View view) {
            flipCell(mImageView);
        }

        private void flipCell(final ImageView imageView) {
        }
    }
}
