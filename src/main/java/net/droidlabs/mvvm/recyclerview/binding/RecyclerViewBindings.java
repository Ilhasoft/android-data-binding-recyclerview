package net.droidlabs.mvvm.recyclerview.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import net.droidlabs.mvvm.recyclerview.adapter.BindingRecyclerViewAdapter;
import net.droidlabs.mvvm.recyclerview.adapter.binder.ItemBinder;
import net.droidlabs.mvvm.recyclerview.events.ClickHandler;
import net.droidlabs.mvvm.recyclerview.events.OnBindViewHolderListener;

import java.util.Collection;

public class RecyclerViewBindings {

    private static final int KEY_ITEMS = -123;
    private static final int KEY_HANDLER = -124;

    @SuppressWarnings("unchecked")
    @BindingAdapter("items")
    public static <T> void setItems(RecyclerView recyclerView, Collection<T> items) {
        BindingRecyclerViewAdapter<T> adapter = (BindingRecyclerViewAdapter<T>) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setItems(items);
        } else {
            recyclerView.setTag(KEY_ITEMS, items);
        }
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter("handler")
    public static <T> void setHandler(RecyclerView recyclerView, ClickHandler<T> handler) {
        BindingRecyclerViewAdapter<T> adapter = (BindingRecyclerViewAdapter<T>) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setClickHandler(handler);
        } else {
            recyclerView.setTag(KEY_HANDLER, handler);
        }
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter("bindListener")
    public static <T> void setOnBindViewHolder(RecyclerView recyclerView
            , OnBindViewHolderListener<T> onBindViewHolderListener) {
        BindingRecyclerViewAdapter<T> adapter = (BindingRecyclerViewAdapter<T>) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setOnBindViewHolderListener(onBindViewHolderListener);
        }
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter("itemViewBinder")
    public static <T> void setItemViewBinder(RecyclerView recyclerView, ItemBinder<T> itemViewMapper) {
        Collection<T> items = (Collection<T>) recyclerView.getTag(KEY_ITEMS);
        ClickHandler<T> clickHandler = (ClickHandler<T>)recyclerView.getTag(KEY_HANDLER);
        BindingRecyclerViewAdapter<T> adapter = new BindingRecyclerViewAdapter<>(itemViewMapper, items);
        adapter.setClickHandler(clickHandler);
        recyclerView.setAdapter(adapter);
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter("selected")
    public static <T> void bindSelectedItem(RecyclerView recyclerView, T item) {
        BindingRecyclerViewAdapter<T> adapter = (BindingRecyclerViewAdapter<T>) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setSelectedItem(item);
            adapter.notifyDataSetChanged();
        }
    }
}
