package com.example.appnote;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.ArrayList;

public class KontenListAdapter extends RecyclerView.Adapter<KontenViewHolder> {

    private ArrayList<Konten> kontenList;
    ArrayList<Konten> checkedKonten = new ArrayList<>();

    public KontenListAdapter(ArrayList<Konten> kontenList){

        this.kontenList = kontenList;
    }

    @Override
    public KontenViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_detail_notes, parent, false);
        return new KontenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KontenViewHolder holder, int position){
        holder.setUpDataToUI(kontenList.get(position));

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                CheckBox cb = (CheckBox) v;

                if (cb.isChecked()){
                    checkedKonten.add(kontenList.get(position));
                }else if (!cb.isChecked()){
                    checkedKonten.remove(kontenList.get(position));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return kontenList.size();
    }

//    @NonNull
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        String title = getItem(position).getTitle();
//        String addnotes = getItem(position).getAddnotes();
//
//        Konten myKonten = new Konten(title,addnotes);
//
//        LayoutInflater inflater = LayoutInflater.from(mContext);
//        convertView = inflater.inflate(mResource, parent, false);
//
//        TextView TV_1 = (TextView) convertView.findViewById(R.id.TV1);
//        TextView TV_2 = (TextView) convertView.findViewById(R.id.TV2);
//
//        TV_1.setText(title);
//        TV_2.setText(addnotes);
//
//        return convertView;
//    }
}
