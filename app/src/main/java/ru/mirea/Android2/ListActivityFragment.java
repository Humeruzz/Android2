package ru.mirea.Android2;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class ListActivityFragment extends Fragment {
    public ListAdapter adapter;
    ImageHolder holder;
    Click click;
    public ListActivityFragment(Click click) {
        this.click = click;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ListAdapter(click);
        List<Item> items = ItemHandler.getInstance().getItems();
        holder = ImageHolder.createInstance(items, this);
        adapter.setImageHolder(holder);
        recyclerView.setAdapter(adapter);
        return v;
    }
}

interface Click {
    void click(int position);
}
