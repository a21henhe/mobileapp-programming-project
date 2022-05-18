package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {

    private List<Tree> listOfTrees;
    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;


    RecyclerviewAdapter(Context context, List<Tree> trees,OnClickListener onClickListener){
        this.layoutInflater = LayoutInflater.from(context);
        this.listOfTrees = trees;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.tree_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapter.ViewHolder holder, int position) {
        holder.name.setText(listOfTrees.get(position).getName());
        ImageView imageView = holder.getImage();
       // new ImageDownloader(imageView).execute(listOfTrees.get(position).auxdata);
    }

    @Override
    public int getItemCount() {
        return listOfTrees.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        ImageView image;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.tree_name);
            image = itemView.findViewById(R.id.tree_img);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(listOfTrees.get(getAdapterPosition()));
        }

        public ImageView getImage() {return image;}
    }

    public interface OnClickListener{
        void onClick(Tree tree);
    }
}
