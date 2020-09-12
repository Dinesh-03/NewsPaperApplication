package com.example.newspaperapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecylerViewAdapter extends RecyclerView.Adapter implements Filterable {
    List<News> recylerHelperClasses;
    List<News> recylerHelperClassesall;
    Context context;

    @Override
    public int getItemViewType(int position) {
        return recylerHelperClasses.get(position).getType();
    }

    private  Recycler_Click recycler_click;

    public RecylerViewAdapter(List<News> recylerHelperClasses,Recycler_Click recycler_click) {
        this.recylerHelperClasses = recylerHelperClasses;
        this.recylerHelperClassesall=new ArrayList<>(recylerHelperClasses);
        this.recycler_click=recycler_click;

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        switch (viewType){
            case News.TYPE_PAPER:
                itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
                return new PaperViewHolder(itemView,recycler_click);
            default:
                itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_details,parent,false);
                return new DetailsViewHolder(itemView,recycler_click);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case News.TYPE_PAPER:
                ((PaperViewHolder)holder).bindView(position);

                break;
            default:
                ((DetailsViewHolder)holder).bindView(position);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return recylerHelperClasses.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter = new Filter() {
        @Override //Runs on a background
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<News> filtered = new ArrayList<>();
            if(charSequence.toString().isEmpty()){
                filtered.addAll(recylerHelperClassesall);
            }else{
                for(News r:recylerHelperClassesall){
                    if(r instanceof RecylerHelperClass && ((RecylerHelperClass)r).getTextView().toLowerCase().contains(charSequence.toString().toLowerCase())){
                        filtered.add(r);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values=filtered;
            filterResults.count=filtered.size();
            return filterResults;
        }
        //Runs on a UI Thread
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            recylerHelperClasses.clear();
            recylerHelperClasses.addAll((List<News>) filterResults.values);
            notifyDataSetChanged();

        }
    };

    public class PaperViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        View view;
        Recycler_Click recycler_click;

        public PaperViewHolder(@NonNull View itemView,Recycler_Click recycler_click) {
            super(itemView);
            this.recycler_click=recycler_click;
            view=itemView;
            itemView.setOnClickListener(this);


        }
        public void  bindView(int position){
            RecylerHelperClass r = (RecylerHelperClass)recylerHelperClasses.get(position);
            imageView=view.findViewById(R.id.recycler_image);
            imageView.setImageResource(r.getImageView());
            textView=view.findViewById(R.id.recycler_text);
            textView.setText(r.getTextView());
        }

        @Override
        public void onClick(View view) {
            recycler_click.recycer_OnClick(getAdapterPosition(),view);
        }
    }
    public class DetailsViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;
        Recycler_Click recycler_click;
        View view;
        public DetailsViewHolder(@NonNull View itemView,Recycler_Click recycler_click) {
            super(itemView);
            view=itemView;
            this.recycler_click=recycler_click;
            itemView.setOnClickListener(this);

        }
        public void  bindView(int position){
            NewsPaperDeatis newsPaper = (NewsPaperDeatis)recylerHelperClasses.get(position);
            textView=view.findViewById(R.id.news_paper_name);
            textView.setText(newsPaper.textDetails);
        }

        @Override
        public void onClick(View view) {
            recycler_click.recycer_OnClick(getAdapterPosition(),view);

        }
    }
    public interface Recycler_Click{
        public void recycer_OnClick(int position, View view);
    }
}
