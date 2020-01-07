package net.droidlabs.mvvm.recyclerview.events;

import androidx.databinding.ViewDataBinding;

import net.droidlabs.mvvm.recyclerview.adapter.BindingRecyclerViewAdapter;

/**
 * Created by johncordeiro on 19/10/15.
 */
public interface OnBindViewHolderListener<T> {

    void onBindViewHolder(BindingRecyclerViewAdapter<T> adapter, ViewDataBinding binding, T item);

}
