package net.droidlabs.mvvm.recyclerview.adapter.binder;

import java.util.HashMap;
import java.util.Map;

public class ItemBinderBase<T> implements ItemBinder<T> {

    protected final int bindingVariable;
    protected final int layoutId;
    protected final Map<Integer, Object> bindingExtraVariables;

    public ItemBinderBase(int bindingVariable, int layoutId)
    {
        this.bindingVariable = bindingVariable;
        this.bindingExtraVariables = new HashMap<>();
        this.layoutId = layoutId;
    }

    public int getLayoutRes(T model)
    {
        return layoutId;
    }

    public int getBindingVariable(T model)
    {
        return bindingVariable;
    }

    public void addVariable(int variableId, Object value) {
        bindingExtraVariables.put(variableId, value);
    }

    @Override
    public Map<Integer, Object> getBindingExtraVariables() {
        return bindingExtraVariables;
    }
}
