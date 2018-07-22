package concentration.tmc.ahujamoh.com.tmc_concentratie.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewCell> {


    @NonNull
    @Override
    public RecyclerViewCell onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewCell recyclerViewCell, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RecyclerViewCell extends RecyclerView.ViewHolder{
        public RecyclerViewCell(@NonNull View itemView) {
            super(itemView);
        }
    }
}
