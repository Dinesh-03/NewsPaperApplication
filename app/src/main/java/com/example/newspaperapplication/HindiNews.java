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


public class HindiNews extends Fragment implements RecylerViewAdapter.Recycler_Click{
    public HindiNews() {
        // Required empty public constructor
    }
    List<News> list = new ArrayList<>();
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hindi_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context=view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.hindiNewsRecyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 1));
        if(list.size()==0) {
            list.add(new RecylerHelperClass(R.drawable.amarujala, "Amarujala", "https://www.amarujala.com/"));
            list.add(new RecylerHelperClass(R.drawable.jagran, "Jagran", "https://www.jagran.com/"));
            list.add(new RecylerHelperClass(R.drawable.dainiknavajyoti, "Dainiknava jyoti", "https://www.dainiknavajyoti.net/"));
            list.add(new RecylerHelperClass(R.drawable.haribhoomi, "Haribhoomi", "https://www.haribhoomi.com/"));
            list.add(new RecylerHelperClass(R.drawable.jansatta, "Jansatta", " https://www.jansatta.com/"));
            list.add(new RecylerHelperClass(R.drawable.navodayatimes, "Navodaya times", "https://www.navodayatimes.in/"));
            list.add(new RecylerHelperClass(R.drawable.navbharattimes, "Navbharat times", "https://navbharattimes.indiatimes.com/"));
            //list.add(new RecylerHelperClass(R.drawable.janmorcha, "Janmorcha", "http://janmorcha.in/"));
            list.add(new RecylerHelperClass(R.drawable.punjabkesari, "Punjab   kesari", "https://m.punjabkesari.in/"));
            list.add(new RecylerHelperClass(R.drawable.patrika, "Patrika", "https://m.patrika.com/"));
            //list.add(new RecylerHelperClass(R.drawable.parichaytimes, "Parichaytimes", "http://www.parichaytimes.info/"));
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