package edu.devmo.frigonnecte.ui.recettes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import edu.devmo.frigonnecte.R;

class RecipeViewHolder extends RecyclerView.ViewHolder {
    private final TextView recipeItemView;

    private RecipeViewHolder(View itemView) {
        super(itemView);
        recipeItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        recipeItemView.setText(text);
    }

    static RecipeViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new RecipeViewHolder(view);
    }
}
