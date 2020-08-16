package com.vnedomovnyi.runlooptest.util.recycler_view;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public abstract class BaseDiffCallback<T> extends DiffUtil.Callback {

    private final List<T> oldList;

    private final List<T> newList;

    public BaseDiffCallback(List<T> oldList, List<T> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    protected abstract boolean areItemsTheSame(T oldItem, T newItem);

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return areItemsTheSame(oldList.get(oldItemPosition), newList.get(newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }

}