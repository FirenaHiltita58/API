package com.example.gangguanpsikologis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    private static final String JSON_URL = "https://raw.githubusercontent.com/caturnugroho14/APITest/master/Film.json";
    ListView listView;
    private List<JenisItem> jenisItemList;


    private LinearLayout jenis1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView =  findViewById(R.id.listView);
        jenisItemList = new ArrayList<>();

        jenis1=findViewById(R.id.jenis);
        jenis1.setOnClickListener((View.OnClickListener) this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                JenisItem playerItem = jenisItemList.get(position);

                Intent i = new Intent(getApplicationContext(), Detail_Jenis.class);
                i.putExtra(Detail_Jenis.EXTRA_JENIS, JenisItem);
                startActivity(i);


            }
        });
        loadJenis();
    }

    private void loadJenis() {
        StringRequest stringRequest = new StringRequest(DownloadManager.Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray playerArray = obj.getJSONArray("result");

                            for (int i = 0; i < playerArray.length(); i++) {

                                JSONObject playerObject = playerArray.getJSONObject(i);


                                JenisItem playerItem = new JenisItem(playerObject.getString("no"),
                                        playerObject.getString("name"),
                                        playerObject.getString("Position"),
                                        playerObject.getString("birth_date"),
                                        playerObject.getString("Poster"));

                                JenisItemList.add(playerItem);
                            }

                            ListViewAdapter adapter = new ListViewAdapter(playerItemList, getApplicationContext());

                            listView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }




    public void onClick(View view) {
        switch (view.getId()){
            case R.id.jenis:
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }

}