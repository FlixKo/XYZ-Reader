package com.example.xyzreader.ui;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xyzreader.R;

public class ArticleBodyAdapter extends RecyclerView.Adapter<ArticleBodyAdapter.ArticleBodyViewHolder> {

    String[] paragraphs;
    @NonNull
    @Override
    public ArticleBodyAdapter.ArticleBodyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context ctx= parent.getContext();
        int layoutIdForListItem = R.layout.article_body_paragraph_item;
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(layoutIdForListItem,parent, false);
        return new ArticleBodyViewHolder(view);
    }

    public void setParagraphs(String[] paragraphs){
        this.paragraphs = paragraphs;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleBodyAdapter.ArticleBodyViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        if(paragraphs==null)
            return 0;
        return paragraphs.length;
    }

    public class ArticleBodyViewHolder extends RecyclerView.ViewHolder{

        TextView paragraphTv;
        public ArticleBodyViewHolder(@NonNull View itemView) {
            super(itemView);
            paragraphTv = itemView.findViewById(R.id.paragraph_text_view);
        }

        void bind(int position){
            String text = paragraphs[position];
            paragraphTv.setText(Html.fromHtml(text));
        }
    }
}
