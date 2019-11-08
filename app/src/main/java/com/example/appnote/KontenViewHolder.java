package com.example.appnote;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


public class KontenViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView TV_1, TV_2;
    CheckBox cb;

    ItemClickListener itemClickListener;

    public KontenViewHolder(View itemView){
        super(itemView);
        TV_1 = itemView.findViewById(R.id.TV1);
        TV_2 = itemView.findViewById(R.id.TV2);
        cb = itemView.findViewById(R.id.cb);

        cb.setOnClickListener(this);
    }

    public void setUpDataToUI(Konten konten) {
        TV_1.setText(konten.getTitle());
        TV_2.setText(konten.getAddnotes());
    }

    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener=ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v, getLayoutPosition());
    }
}
