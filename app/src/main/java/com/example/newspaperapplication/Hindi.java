package com.example.newspaperapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;


import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.newspaperapplication.databinding.ActivityHindiBinding;
import com.example.newspaperapplication.databinding.ActivityTamilBinding;

import java.util.ArrayList;
import java.util.List;

public class Hindi extends AppCompatActivity implements RecylerViewAdapter.Recycler_Click {
    ActivityHindiBinding mainBinding;
    RecyclerView recyclerView;
    SearchView searchView;
    List<News> list = new ArrayList<>();
    Context context;
    LinearLayout frameLayout;
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
    RecylerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_hindi);
        frameLayout=findViewById(R.id.frame_layout);
        searchView=mainBinding.searchQuery;
        searchView.setVisibility(View.VISIBLE);
        final HindiNews hindiNews = new HindiNews(searchView);
        if(!fragmentTransaction.isEmpty()){
            fragmentTransaction.remove(hindiNews);
        }
        fragmentTransaction.replace(frameLayout.getId(),hindiNews).commit();
        searchQuery(hindiNews);
    }
    public void languagemenu(View view) {
        PopupMenu popupMenu = new PopupMenu(context,view);
        popupMenu.inflate(R.menu.lanugage_menu);
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id=menuItem.getItemId();
                Intent intent ;
                switch (id){
                    case R.id.hindi:
                        Toast.makeText(context,"You are already in Hindi News",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tamil:
                        intent=new Intent(Hindi.this,Tamil.class);
                        intent.putExtra("Language",R.string.tamil);
                        startActivity(intent);
                        break;
                    case R.id.english:
                        intent=new Intent(Hindi.this,English.class);
                        intent.putExtra("Language",R.string.english);
                        startActivity(intent);
                        break;
                }
                return true;
            }

        });
    }
    public void tabClicked(View view) {
        switch (view.getId()){
            case R.id.newsPaper:
                Toast.makeText(context,"NewsPaper",Toast.LENGTH_SHORT).show();
                searchView.setVisibility(View.VISIBLE);
                HindiNews hindiNews = new HindiNews(searchView);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                if(!fragmentTransaction.isEmpty()){
                    fragmentTransaction.remove(hindiNews);
                }
                fragmentTransaction.replace(frameLayout.getId(),hindiNews);
                fragmentTransaction.commit();
                searchQuery(hindiNews);
                break;
            case R.id.newsVideos:
                Toast.makeText(context,"NewsVideos", Toast.LENGTH_SHORT).show();
                searchView.setVisibility(View.GONE);
                HindiNewsVideos hindiNewsVideos=new HindiNewsVideos();
                FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(frameLayout.getId(),hindiNewsVideos).addToBackStack("TamilNews");
                fragmentTransaction2.commit();
                break;


        }
    }

    @Override
    public void recycer_OnClick(int position, View view) {

    }
    public void searchQuery(final HindiNews hindiNews){

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                hindiNews.recylerViewAdapter.getFilter().filter(s);
                return true;
            }
        });
    }
}