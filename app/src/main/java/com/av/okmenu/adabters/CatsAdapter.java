package com.av.okmenu.adabters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.av.okmenu.R;
import com.av.okmenu.classes.Category;
import com.av.okmenu.classes.Urls;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mina on 3/6/2018.
 */

public class CatsAdapter extends RecyclerView.Adapter<CatsAdapter.ViewHolder> {

     private List<Category> categoriesList;
     private Context context;

    public CatsAdapter(Context context,List<Category> categoriesList) {
        this.categoriesList = categoriesList;
        this.context=context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView cat_name_tv;
        ImageView cat_img_iv;
        ViewHolder(View view) {
            super(view);
            cat_img_iv=view.findViewById(R.id.cat_img_iv);
            cat_name_tv=view.findViewById(R.id.cat_name_tv);
        }

    }

    @Override
    public  ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cat_lis_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Category category=categoriesList.get(position);
        holder.cat_name_tv.setText(category.getCategoryName());
        Picasso.with(context).load(Urls.IMG_URL_CATEGORY+category.getCategoryImage()).resize(160,140).into(holder.cat_img_iv);
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }
}
