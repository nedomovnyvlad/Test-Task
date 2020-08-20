package com.vnedomovnyi.testtask.ui.screen.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.vnedomovnyi.testtask.R;
import com.vnedomovnyi.testtask.entity.Article;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text_title)
    TextView titleTextView;

    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public static ArticleViewHolder create(ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_article, parent, false);

        return new ArticleViewHolder(view);
    }

    public void bind(Article article, @Nullable OnArticleClickListener listener) {
        titleTextView.setText(article.getTitle());

        if (listener != null) {
            itemView.setOnClickListener(ignored -> listener.onClick(article));
        }
    }

    public interface OnArticleClickListener {

        void onClick(Article article);

    }

}
