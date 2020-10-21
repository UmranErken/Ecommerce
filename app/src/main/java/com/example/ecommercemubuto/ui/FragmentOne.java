package com.example.ecommercemubuto.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommercemubuto.R;
import com.example.ecommercemubuto.ui.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends Fragment {
        View v;
        private RecyclerView myrecyclerview;
        private List<Home>lstHome;

    public FragmentOne() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_one,container,false);
        myrecyclerview=  v.findViewById(R.id.one_recycler);
        RecyclerViewAdapter recyclerAdapter=new RecyclerViewAdapter(getContext(),lstHome);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
              lstHome=new ArrayList<>();
        lstHome.add(new Home(R.drawable.one_item_dress));
        lstHome.add(new Home(R.drawable.one_item_colins));
        lstHome.add(new Home(R.drawable.one_item_shoe));
        lstHome.add(new Home(R.drawable.one_item_dress));
        lstHome.add(new Home(R.drawable.one_item_colins));
        lstHome.add(new Home(R.drawable.one_item_shoe));
        lstHome.add(new Home(R.drawable.one_item_dress));
        lstHome.add(new Home(R.drawable.one_item_colins));
        lstHome.add(new Home(R.drawable.one_item_shoe));
        lstHome.add(new Home(R.drawable.one_item_dress));
        lstHome.add(new Home(R.drawable.one_item_colins));
        lstHome.add(new Home(R.drawable.one_item_shoe));


    }
}
