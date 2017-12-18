package nyc.c4q.retrofitexercise3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by yokilam on 12/17/17.
 */

class HoundAdapter extends RecyclerView.Adapter<HoundAdapter.HoundViewHolder> {

    List<String> listHound;
    Context context;

    public HoundAdapter(List <String> listHound, Context context) {
        this.listHound = listHound;
        this.context = context;
    }

    public class HoundViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        public HoundViewHolder(View itemView) {
            super(itemView);

            image= itemView.findViewById(R.id.imageview);

        }
    }

    @Override
    public HoundAdapter.HoundViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dog_itemview, parent, false);
        return new HoundViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HoundAdapter.HoundViewHolder holder, int position) {
        Picasso.with(context).load(String.valueOf(listHound.get(position))).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return listHound.size();
    }

}
