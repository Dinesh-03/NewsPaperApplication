package com.example.newspaperapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class EnglishNewsVideos extends Fragment {
    Context context;
    CardView indiatoday,republic,cnnnews,skynews,ddindia;

    public EnglishNewsVideos() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_english_news_videos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context=view.getContext();
        indiatoday=view.findViewById(R.id.indiatoday);
        republic=view.findViewById(R.id.republic);
        cnnnews=view.findViewById(R.id.cnnnews);
        skynews = view.findViewById(R.id.skynews);
        ddindia=view.findViewById(R.id.ddindia);

        final Intent intent =new Intent(context,YoutubePlayerService.class);
        indiatoday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.indiatoday);
                startActivity(intent);
            }
        });
        republic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.republic);
                startActivity(intent);

            }
        });
        cnnnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.cnnnews18);
                startActivity(intent);

            }
        });
        skynews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.skynews);
                startActivity(intent);

            }
        });

        ddindia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.ddindia);
                startActivity(intent);
            }
        });


    }


}