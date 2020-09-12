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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.newspaperapplication.databinding.ActivityTamilBinding;

import java.util.ArrayList;
import java.util.List;

public class Tamil extends AppCompatActivity implements RecylerViewAdapter.Recycler_Click  {
    ActivityTamilBinding mainBinding;
    RecyclerView recyclerView;
    SearchView searchView;
    List<News> list = new ArrayList<>();
    Context context;
    LinearLayout frameLayout;
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
    RecylerViewAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_tamil);
        frameLayout = findViewById(R.id.frame_layout);
        searchView = mainBinding.searchQuery;
        searchView.setVisibility(View.VISIBLE);
         final TamilNews tamilNews = new TamilNews(searchView);


        if (!fragmentTransaction.isEmpty()) {
            fragmentTransaction.remove(tamilNews);
        }
        fragmentTransaction.replace(frameLayout.getId(), tamilNews).commit();

         searchQuery(tamilNews);
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
                    case R.id.tamil:
                        Toast.makeText(context,"You are already in Tamil News",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.hindi:
                        intent=new Intent(Tamil.this,Hindi.class);
                        intent.putExtra("Language",R.string.Hindi);
                        startActivity(intent);
                        break;
                    case R.id.english:
                        intent=new Intent(Tamil.this,English.class);
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
                TamilNews tamilNews = new TamilNews(searchView);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                if(!fragmentTransaction.isEmpty()){
                    fragmentTransaction.remove(tamilNews);
                }
                fragmentTransaction.replace(frameLayout.getId(),tamilNews);
                fragmentTransaction.commit();
                searchQuery(tamilNews);
                break;
            case R.id.newsVideos:
                Toast.makeText(context,"NewsVideos", Toast.LENGTH_SHORT).show();
                searchView.setVisibility(View.GONE);
                TamilNewsVideos tamilNewsVideos=new TamilNewsVideos();
                FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(frameLayout.getId(),tamilNewsVideos).addToBackStack("TamilNews");
                fragmentTransaction2.commit();
                break;


        }
    }

    @Override
    public void recycer_OnClick(int position, View view) {

    }
    public void searchQuery(final TamilNews tamilNews){

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                tamilNews.recylerViewAdapter.getFilter().filter(s);
                return true;
            }
        });
    }

}