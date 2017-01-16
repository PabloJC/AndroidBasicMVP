package com.pabji.basicmvp.presentation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pabji.basicmvp.R;
import com.pabji.basicmvp.presentation.mvp.models.Recipe;
import com.pabji.basicmvp.presentation.utils.CircleTransformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Pablo Jiménez Casado on 06/08/2016.
 */

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeItemHolder> {

    private List<Recipe> listItem = new ArrayList<>();
    private int lastPosition = -1;

    @Inject
    public RecipeListAdapter(){}

    @Override
    public RecipeListAdapter.RecipeItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe_list, parent, false);
        return new RecipeItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeListAdapter.RecipeItemHolder holder, int position) {
        holder.bindItem(listItem.get(position),position);
    }

    @Override
    public int getItemCount() {
        return this.listItem.size();
    }


    public void setData(List<Recipe> commentList) {
        this.listItem = commentList;
        this.notifyDataSetChanged();
    }

    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(listItem, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(listItem, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    public void onItemDismiss(int adapterPosition) {
        listItem.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }


    public class RecipeItemHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tv_title)
        TextView itemTitle;


        public RecipeItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindItem(Recipe recipe, int position) {
            itemTitle.setText(recipe.name);
            if (position > lastPosition)
            {
                Animation animation = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.slide_up);
                itemView.startAnimation(animation);
                lastPosition = position;
            }
        }
    }

}
