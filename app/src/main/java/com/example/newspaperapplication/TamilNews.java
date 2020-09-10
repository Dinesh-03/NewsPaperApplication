package com.example.newspaperapplication;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class TamilNews extends Fragment implements RecylerViewAdapter.Recycler_Click{
    public TamilNews() {
        // Required empty public constructor
    }
    List<News> list = new ArrayList<>();
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tamil_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context=view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.tamilNewsRecyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 1));
        if(list.size()==0) {
            list.add(new RecylerHelperClass(R.drawable.dinamani, "Dinamani", "https://www.dinamani.com/"));
            list.add(new RecylerHelperClass(R.drawable.thina_thanthi, "Dhinathanthi", "https://www.dailythanthi.com/"));
            list.add(new RecylerHelperClass(R.drawable.dina_malar, "Dhinamalar", "https://www.dinamalar.com/"));
        }
        final RecylerViewAdapter recylerViewAdapter = new RecylerViewAdapter(list,this);
        recyclerView.setAdapter(recylerViewAdapter);

    }

    @Override
    public void recycer_OnClick(int position, View view) {
        News news = list.get(position);
        if(news instanceof RecylerHelperClass) {
            RecylerHelperClass helperClass = (RecylerHelperClass)list.get(position);
            String title = helperClass.getNewsLink();
            Intent intent = new Intent(context, NewsPaper.class);
            intent.putExtra("newsPaperDetails", title);
            startActivity(intent);
        }else
        {
            NewsPaperDeatis helperClass = (NewsPaperDeatis) list.get(position);
            String title = helperClass.getNewsLink();
            Intent intent = new Intent(context, NewsPaper.class);
            intent.putExtra("newsPaperDetails", title);
            startActivity(intent);

        }
    }
}