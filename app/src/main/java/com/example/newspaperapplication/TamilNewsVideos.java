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


public class TamilNewsVideos extends Fragment {
    Context context;
    CardView polimer,puthiya,sunnews,news7tamil,sathiyam,news18,jayaplus,rajnews,kalaingar,newj;

    public TamilNewsVideos() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tamil_news_videos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context=view.getContext();
        polimer=view.findViewById(R.id.polimer);
        puthiya=view.findViewById(R.id.puthiya);
        sunnews=view.findViewById(R.id.sunnews);
        news7tamil=view.findViewById(R.id.news7tamil);
        sathiyam=view.findViewById(R.id.sathiyam);
        news18 = view.findViewById(R.id.news18);
        jayaplus=view.findViewById(R.id.jayaplus);
        kalaingar=view.findViewById(R.id.kalaingar);
        rajnews=view.findViewById(R.id.rajnews);
        newj=view.findViewById(R.id.newsj);
        final Intent intent =new Intent(context,YoutubePlayerService.class);
        polimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.polimer);
                startActivity(intent);
            }
        });
        puthiya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.puthiya);
                startActivity(intent);

            }
        });
        sunnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.sunnews);
                startActivity(intent);

            }
        });
        news7tamil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.news7tamil);
                startActivity(intent);

            }
        });
        sathiyam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.sathiyam);
                startActivity(intent);

            }
        });
        news18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.news18);
                startActivity(intent);

            }
        });
        jayaplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.jayaplus);
                startActivity(intent);
            }
        });
        rajnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.rajnews);
                startActivity(intent);
            }
        });
        kalaingar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.kalaingar);
                startActivity(intent);
            }
        });
        newj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.newsj);
                startActivity(intent);
            }
        });


    }


}