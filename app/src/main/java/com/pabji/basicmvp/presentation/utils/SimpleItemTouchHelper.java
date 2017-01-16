package com.pabji.basicmvp.presentation.utils;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.pabji.basicmvp.presentation.adapters.RecipeListAdapter;

import javax.inject.Inject;

/**
 * Created by pablojimenez on 16/1/17.
 */


public class SimpleItemTouchHelper extends ItemTouchHelper.Callback {


    private RecipeListAdapter mAdapter;

    @Inject
    public SimpleItemTouchHelper(){}

    public void setAdapter(RecipeListAdapter adapter) {
        mAdapter = adapter;
    }



    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                          RecyclerView.ViewHolder target) {
        mAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

}
