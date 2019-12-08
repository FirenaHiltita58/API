package com.example.gangguanpsikologis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<JenisItem> {


    private List<JenisItem> JenisItemList;

    private Context context;

    public ListViewAdapter(List<JenisItem> jenisItemList, Context context) {
        super(context, R.layout.activity_list_item, jenisItemList);
        this.JenisItemList = jenisItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.activity_list_item, null, true);

        TextView textViewNama = listViewItem.findViewById(R.id.textViewNama);
        TextView textViewPenjelasan = listViewItem.findViewById(R.id.textViewPenjelasan);


        JenisItem playerItem = JenisItemList.get(position);

        textViewNama.setText(playerItem.getNama());
        textViewPenjelasan.setText(playerItem.getPenjelasan());

        return listViewItem;
    }
}
