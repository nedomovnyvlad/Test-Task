package com.vnedomovnyi.testtask.util.recycler_view;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<Entity, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> {

    protected final List<Entity> list = new ArrayList<>();

    protected abstract DiffUtil.Callback getDiffCallback(List<Entity> oldList, List<Entity> newList);

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected Entity getItem(int position) {
        return list.get(position);
    }

    public void setData(List<Entity> newList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(
                getDiffCallback(this.list, newList)
        );

        this.list.clear();
        this.list.addAll(newList);
        diffResult.dispatchUpdatesTo(this);
    }

}
