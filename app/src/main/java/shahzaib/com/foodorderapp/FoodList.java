package shahzaib.com.foodorderapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import shahzaib.com.foodorderapp.Interface.ItemClickListener;
import shahzaib.com.foodorderapp.Model.Food;
import shahzaib.com.foodorderapp.ViewHolder.FoodViewHolder;

public class FoodList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference foodlist;

    String categoryID = "";
    String ss;
    FirebaseRecyclerAdapter<Food,FoodViewHolder> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        //Firebase
        database = FirebaseDatabase.getInstance();
        foodlist = database.getReference("Foodssss");
        recyclerView = findViewById(R.id.recycleVFood);
        recyclerView .setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if(getIntent() != null)
            categoryID = getIntent().getStringExtra("CategorID");
            if(categoryID.isEmpty() && categoryID != null){
                Toast.makeText(FoodList.this,""+categoryID,Toast.LENGTH_SHORT).show();

                adapter = new FirebaseRecyclerAdapter<Food, FoodViewHolder>(Food.class,R.layout.food_item
                        ,FoodViewHolder.class,
                        foodlist) {
                    @Override
                    protected void populateViewHolder(FoodViewHolder viewHolder, Food model, int position) {
                        viewHolder.foodName.setText(model.getName());
                        Picasso.with(getBaseContext()).load(model.getImage())
                                .into(viewHolder.foodImage);
                        final Food click = model;
                        viewHolder.setItemClickListener(new ItemClickListener() {
                            @Override
                            public void onClick(View view, int position, boolean isLongClick) {
                                Toast.makeText(FoodList.this,""+click.getName(),Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                };
                recyclerView.setAdapter(adapter);
            }

        Toast.makeText(FoodList.this,""+categoryID,Toast.LENGTH_SHORT).show();


    }

    private void LoadListFood(String categoryID) {

    }
}
