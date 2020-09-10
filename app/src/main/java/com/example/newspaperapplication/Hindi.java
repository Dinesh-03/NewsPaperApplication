package com.example.newspaperapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newspaperapplication.databinding.ActivityEnglishBinding;
import com.example.newspaperapplication.databinding.ActivityHindiBindingImpl;

import java.util.ArrayList;
import java.util.List;

public class Hindi extends AppCompatActivity implements RecylerViewAdapter.Recycler_Click{
    Context context;
    ActivityHindiBindingImpl hindiBinding;
    SearchView searchView;
    RecyclerView recyclerView;
    List<RecylerHelperClass>list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hindiBinding= DataBindingUtil.setContentView(this,R.layout.activity_hindi);
        context=this;
        Intent intent = getIntent();
        int id= intent.getExtras().getInt("Language");


    }

    public void languagemenu(View view) {
        PopupMenu popupMenu = new PopupMenu(context,view);
        popupMenu.inflate(R.menu.lanugage_menu);
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id=menuItem.getItemId();
                Intent intent ;
                switch (id){
                    case R.id.tamil:
                        intent = new Intent(Hindi.this,Tamil.class);
                        intent.putExtra("Language",R.string.tamil);
                        startActivity(intent);
                        break;
                    case R.id.english:
                        intent=new Intent(Hindi.this,Hindi.class);
                        intent.putExtra("Language",R.string.english);
                        startActivity(intent);
                        break;
                    case R.id.hindi:
                        Toast.makeText(context,"You are already in Hindi 1",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

    }


    @Override
    public void recycer_OnClick(int position, View view) {


    }
}