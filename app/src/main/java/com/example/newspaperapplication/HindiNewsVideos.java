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


public class HindiNewsVideos extends Fragment {
    Context context;
    CardView news18hindi,aajtak,ndtvhindi,tv9,abpnews,cnbc,ddnews,newsnation,indiatvhindi;

    public HindiNewsVideos() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hindi_news_videos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context=view.getContext();
        news18hindi=view.findViewById(R.id.news18hindi);
        aajtak=view.findViewById(R.id.aajtak);
        ndtvhindi=view.findViewById(R.id.ndtvhindi);
        tv9=view.findViewById(R.id.tv9);
        abpnews=view.findViewById(R.id.abpnews);
        cnbc = view.findViewById(R.id.cnbc);
        ddnews=view.findViewById(R.id.ddnews);
        newsnation=view.findViewById(R.id.newsnation);
        indiatvhindi=view.findViewById(R.id.indiatvhindi);

        final Intent intent =new Intent(context,YoutubePlayerService.class);
        news18hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.news18hindi);
                startActivity(intent);
            }
        });
        aajtak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.aajtak);
                startActivity(intent);

            }
        });
        ndtvhindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.ndtvhindi);
                startActivity(intent);

            }
        });
        tv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.tv9);
                startActivity(intent);

            }
        });
        abpnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.abpnews);
                startActivity(intent);

            }
        });
        cnbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.cnbc);
                startActivity(intent);

            }
        });
        ddnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.ddnews);
                startActivity(intent);
            }
        });
        newsnation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.newsnation);
                startActivity(intent);
            }
        });
        indiatvhindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("videoLink",R.string.indiatvhindi);
                startActivity(intent);
            }
        });
    }


}
