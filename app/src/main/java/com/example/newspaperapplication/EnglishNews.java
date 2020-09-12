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
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;


public class EnglishNews extends Fragment implements RecylerViewAdapter.Recycler_Click{
    SearchView searchView;
    public EnglishNews(SearchView searchView) {
        this.searchView=searchView;
        // Required empty public constructor
    }
    List<News> list = new ArrayList<>();
    Context context;
    RecylerViewAdapter recylerViewAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragement_english_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context=view.getContext();
        searchView.setVisibility(View.VISIBLE);
        RecyclerView recyclerView = view.findViewById(R.id.englishNewsRecyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 1));
        if(list.size()==0) {
            list.add(new RecylerHelperClass(R.drawable.thehindu, "TheHindu", "https://www.thehindu.com/"));
            list.add(new RecylerHelperClass(R.drawable.indiatoday, "India Today", "https://www.indiatoday.in/"));
            list.add(new RecylerHelperClass(R.drawable.deccanchronicle, "Deccan   Chronicle", "https://www.deccanchronicle.com/"));
            list.add(new RecylerHelperClass(R.drawable.hindustantimes, "Hindustan Times", "https://www.hindustantimes.com/"));
            list.add(new RecylerHelperClass(R.drawable.ahmedabadmirror, "Ahmedabad Mirror", "https://ahmedabadmirror.indiatimes.com/"));
            list.add(new RecylerHelperClass(R.drawable.asianage, "Asianage", "http://www.asianage.com/"));
            list.add(new RecylerHelperClass(R.drawable.businessline, "The Hindu Business line", "https://www.thehindubusinessline.com/"));
            list.add(new RecylerHelperClass(R.drawable.business, "Business Standard", "https://www.business-standard.com/todays-paper/"));
            list.add(new RecylerHelperClass(R.drawable.dailyexcelsior, "Daily   Excelsior", "https://www.dailyexcelsior.com/"));
            list.add(new RecylerHelperClass(R.drawable.dnaindia, "DNA India", "https://www.dnaindia.com/"));
            list.add(new RecylerHelperClass(R.drawable.deccanherald, "Deccan   Herald", "https://www.deccanherald.com/"));
            list.add(new RecylerHelperClass(R.drawable.financialexpress, "Financial Express", "https://www.financialexpress.com/"));
            list.add(new RecylerHelperClass(R.drawable.freepress, "Free Press journal", "https://www.freepressjournal.in/"));
            list.add(new RecylerHelperClass(R.drawable.greaterkashmir, "Greater Kashmir", "https://www.greaterkashmir.com/"));
            list.add(new RecylerHelperClass(R.drawable.heraldgoa, "Herald Goa", "https://www.heraldgoa.in/index.php"));
            list.add(new RecylerHelperClass(R.drawable.orissapost, "Orissa post", "https://www.orissapost.com/"));
            list.add(new RecylerHelperClass(R.drawable.mumbaimirror, "Mumbai   Mirror", "https://mumbaimirror.indiatimes.com/" ));
            //list.add(new RecylerHelperClass(R.drawable.nagalandpost, "Nagaland   post", "http://www.nagalandpost.com/"));
            list.add(new RecylerHelperClass(R.drawable.dailypioneer, "Daily Pioneer", "https://www.dailypioneer.com/"));
            list.add(new RecylerHelperClass(R.drawable.timesofindia, "Times of   India", "https://m.timesofindia.com/"));
        }
        recylerViewAdapter = new RecylerViewAdapter(list,this);
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
    public  List<News> newsList(){
        return list;
    }
    public RecylerViewAdapter getRecyclerAdapter(){
        return  recylerViewAdapter;
    }
}