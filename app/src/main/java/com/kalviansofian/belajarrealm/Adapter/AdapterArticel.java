package com.kalviansofian.belajarrealm.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kalviansofian.belajarrealm.Model.ArticelModel;
import com.kalviansofian.belajarrealm.R;

import java.util.ArrayList;

/**
 * Created by root on 18/06/16.
 */
public class AdapterArticel extends RecyclerView.Adapter<AdapterArticel.ViewHolder> {


    private final OnItemClickListener listener;
    private ArrayList<ArticelModel> article;


    public AdapterArticel(ArrayList<ArticelModel> article, OnItemClickListener listener) {
        this.article = article;
        this.listener = listener;
    }


    @Override
    public AdapterArticel.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_articel, null);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(AdapterArticel.ViewHolder holder, int position) {
        holder.click(article.get(position), listener);
        holder.tvId.setText(String.valueOf(article.get(position).getId()));
        holder.title.setText(article.get(position).getTitle());
        holder.description.setText(article.get(position).getDescription());
    }


    @Override
    public int getItemCount() {
        return article.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, title, description;


        public ViewHolder(View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            description = (TextView) itemView.findViewById(R.id.tvDescription);
        }


        public void click(final ArticelModel articleModel, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(articleModel);
                }
            });
        }
    }


    public interface OnItemClickListener {
        void onClick(ArticelModel item);
    }
}
