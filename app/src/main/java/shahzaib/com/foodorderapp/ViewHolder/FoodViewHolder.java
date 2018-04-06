package shahzaib.com.foodorderapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import shahzaib.com.foodorderapp.Interface.ItemClickListener;
import shahzaib.com.foodorderapp.R;

/**
 * Created by shahzaib on 4/6/2018.
 */

public class FoodViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView foodName;
    public ImageView foodImage;

    private ItemClickListener itemClickListener;

    public FoodViewHolder(View itemView) {
        super(itemView);
        foodName = itemView.findViewById(R.id.food_name);
        foodImage = itemView.findViewById(R.id.food_image);
        itemView.setOnClickListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
