package com.thickman.brewbro;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private List<Recipe> mDataset;
    private Context ctx;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
        public TextView txtOG;
        public TextView txtFG;
        public TextView txtABV;
        public TextView txtIBU;
        public TextView txtSRM;
        public TextView txtColor;

        public ViewHolder(View v) {
            super(v);
            txtName = (TextView) v.findViewById(R.id.txtName);
            txtOG = (TextView) v.findViewById(R.id.txtOG);
            txtFG = (TextView) v.findViewById(R.id.txtFG);
            txtABV = (TextView) v.findViewById(R.id.txtABV);
            txtIBU = (TextView) v.findViewById(R.id.txtIBU);
            txtSRM = (TextView) v.findViewById(R.id.txtSRM);
            txtColor = (TextView) v.findViewById(R.id.txtColor);
        }
    }

    public RecipeAdapter(List<Recipe> recipeList, Context ctx) {
        mDataset = recipeList;
        this.ctx = ctx;
    }

    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_recipe, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(mDataset.get(position).getName());
        holder.txtOG.setText("OG: " + Functions.limitPrecision(String.valueOf(mDataset.get(position).getOriginalGravity()), 3));
        holder.txtFG.setText("FG: " + Functions.limitPrecision(String.valueOf(mDataset.get(position).getFinalGravity()), 3));
        holder.txtABV.setText("ABV: " + Functions.limitPrecision(String.valueOf(mDataset.get(position).getABV()), 2));
        holder.txtIBU.setText("IBU: " + Functions.limitPrecision(String.valueOf(mDataset.get(position).getIBURager()), 2));
        holder.txtSRM.setText("SRM: " + Functions.limitPrecision(String.valueOf(mDataset.get(position).getSRM()), 1));

        int SRM = (int) Math.floor(mDataset.get(position).getSRM());
        if (SRM < 40) {
            TypedArray colors = ctx.getResources().obtainTypedArray(R.array.srm_colors);
            holder.txtColor.setBackgroundColor(colors.getColor(SRM - 1, 0));
        }
        else {
            TypedArray colors = ctx.getResources().obtainTypedArray(R.array.srm_colors);
            holder.txtColor.setBackgroundColor(colors.getColor(39, 0));
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}